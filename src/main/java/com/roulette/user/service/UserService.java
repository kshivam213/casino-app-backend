package com.roulette.user.service;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.daoImpl.BetDaoImpl;
import com.roulette.daoImpl.GameDaoImpl;
import com.roulette.daoImpl.UserDaoImpl;
import com.roulette.entity.Bet;
import com.roulette.entity.Games;
import com.roulette.entity.Users;
import com.roulette.models.AppResponse;
import com.roulette.user.interfaces.UserInterface;
import com.roulette.user.models.BetModel;
import com.roulette.user.models.UserModel;
import com.roulette.user.utils.UserUtitlites;
import com.roulette.utils.CommonUtils;

@Service("userService")
public class UserService implements UserInterface {

	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private GameDaoImpl gameDaoImpl;

	@Autowired
	private BetDaoImpl betDaoImpl;
	
	@Override
	public AppResponse registerUser(UserModel userModel) {

		CommonUtils.preCondition(userModel == null, "UserModel cant be null");
		CommonUtils.preCondition(userModel.getUserName() == null, "username can't be null");
		CommonUtils.preCondition(userModel.getBalance() == null, "Balance can't be null");
		CommonUtils.preCondition(userModel.getBalance() <= 0, "Balance can't be less than 0");
	
		Users user = new Users();
		user.setUserName(userModel.getUserName());
		user.setBalance(userModel.getBalance());

		user = userDaoImpl.saveUser(user);

		userModel = UserUtitlites.convertUserEntityToModel(user);

		return AppResponse.builder().result(userModel).description("User registered").success(true).build();
	}

	@Override
	public AppResponse enterCasino(UserModel userModel) {

		CommonUtils.preCondition(userModel.getUserId() == null, "userId can't be null");
		CommonUtils.preCondition(userModel.getCasinoName() == null, "Casino Name can't be null");

		Users user = userDaoImpl.findUserById(userModel.getUserId());

		user.setCashinoName(userModel.getCasinoName());

		user = userDaoImpl.saveUser(user);

		userModel = UserUtitlites.convertUserEntityToModel(user);

		return AppResponse.builder().result(userModel).description("Casino Added").success(true).build();
	}

	@Override
	public AppResponse rechargeBalance(UserModel userModel) {
		
		CommonUtils.preCondition(userModel.getUserId() == null, "userId can't be null");
		CommonUtils.preCondition(userModel.getBalance() == null, "Recharge amount can't be null");

		Users user = userDaoImpl.findUserById(userModel.getUserId());
		user.setBalance(user.getBalance()+userModel.getBalance());
		
		user = userDaoImpl.saveUser(user);

		userModel = UserUtitlites.convertUserEntityToModel(user);

		return AppResponse.builder().result(userModel).description("Recharged Your balance").success(true).build();
		
	}

	@Override
	public AppResponse listAllBettableGame(Long userId) {
		
		Users user = userDaoImpl.findUserById(userId);
		
		UserModel userModel = UserUtitlites.convertUserEntityToModel(user);
		return AppResponse.builder().result(userModel).description("Recharged Your balance").success(true).build();

	}

	@Override
	@Transactional
	public AppResponse betOnGame(UserModel userModel) {
		
		Games game = gameDaoImpl.findGameById(userModel.getGameId());
		Users user = userDaoImpl.findUserById(userModel.getUserId());
		
		CommonUtils.preCondition(!game.isStatus(), "Game is not active");
		CommonUtils.preCondition(userModel.getBetModels().isEmpty(), "No bet model present");
		
		BetModel betModel = userModel.getBetModels().get(0);
		CommonUtils.preCondition(betModel.getBetAmount() == null, "Bet Amount can't be null");
		CommonUtils.preCondition(betModel.getBetNumber() == null, "Please choose bet number");
		
		Bet bet = new Bet();
		bet.setUser(user);
		bet.setGame(game);
		bet.setBetAmount(betModel.getBetAmount());
		bet.setBetStatus(false);
		bet.setBetNumber(betModel.getBetNumber());
		
		bet = betDaoImpl.saveBet(bet);
		
		user.setBet(bet);
		user = userDaoImpl.saveUser(user);
		
		game.setBets(bet);
		
		gameDaoImpl.addGame(game);
		
		betModel = UserUtitlites.convertBetEntityToModel(bet);
		
		return AppResponse.builder().result(betModel).description("You betted").success(true).build();
	}

	@Override
	public AppResponse cashOut(Long userId) {
		
		Users user = userDaoImpl.findUserById(userId);
		Double balance = user.getBalance();
		user.setBalance(0.0);
		user = userDaoImpl.saveUser(user);

		UserModel userModel = UserUtitlites.convertUserEntityToModel(user);
		Map<String, Object> result= new LinkedHashMap<String, Object>();
		result.put("cash", balance);
		result.put("userModel", userModel);
		
		return AppResponse.builder().result(result).description("Cash Out").success(true).build();
		
	}
}
