package com.roulette.game.services;

import java.time.Instant;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.daoImpl.BetDaoImpl;
import com.roulette.daoImpl.CasinoDaoImpl;
import com.roulette.daoImpl.DealerDaoImpl;
import com.roulette.daoImpl.GameDaoImpl;
import com.roulette.daoImpl.UserDaoImpl;
import com.roulette.entity.Bet;
import com.roulette.entity.Casino;
import com.roulette.entity.Dealers;
import com.roulette.entity.Games;
import com.roulette.entity.Users;
import com.roulette.game.interfaces.GameInterface;
import com.roulette.game.models.GameModel;
import com.roulette.game.utils.GameUtilities;
import com.roulette.models.AppResponse;
import com.roulette.utils.CommonUtils;

@Service("gameService")
public class GameService implements GameInterface{
	
	@Autowired
	private DealerDaoImpl dealerRepo;
	
	@Autowired
	private GameDaoImpl gameRepo;
	
	@Autowired
	private BetDaoImpl betDaoImpl;
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private CasinoDaoImpl casinoDaoImpl;

	@Override
	public AppResponse startGame(Long dealerId) {
		
		Dealers dealer= dealerRepo.findDealerById(dealerId);
		Games game= new Games();
		game.setStartTime(Instant.now().getEpochSecond());
		game.setStatus(true);
		game.setDealer(dealer);
		
		game= gameRepo.addGame(game);
		
		GameModel gameModel = GameUtilities.convertGameEntityToModel(game, dealerId);
		return AppResponse.builder().result(gameModel).description("Game Started").success(true).build();
	}

	@Override
	@Transactional
	public AppResponse closeGame(GameModel gameModel) {
		
		Games game= gameRepo.findGameById(gameModel.getGameId());
        CommonUtils.preCondition(game.getDealer().getDealerId() != gameModel.getDealerId(), "Invalid Dealer");
		
		Random rand = new Random(); 

		game.setStatus(false);
		game.setEndTime(Instant.now().getEpochSecond());
		
		Integer thrownNum= rand.nextInt(36)+1;
		game.setThrownNumber(thrownNum);
		
		for(Bet bet: game.getBets()) {
			
			Users user = bet.getUser();
			if(bet.getBetNumber() == thrownNum) {
				user.setBalance(user.getBalance() *2);
				bet.setBetStatus(true);
				
				betDaoImpl.saveBet(bet);
			}else {
				user.setBalance(user.getBalance() - bet.getBetAmount());
				Casino casino = casinoDaoImpl.findByCasinoName(user.getCashinoName());
				casino.setBalance(casino.getBalance() + bet.getBetAmount());
				
				casinoDaoImpl.saveCasino(casino);
			}
			
			userDaoImpl.saveUser(user);
		}
		
		game = gameRepo.addGame(game);
		
		gameModel = GameUtilities.convertGameEntityToModel(game, gameModel.getDealerId());
		return AppResponse.builder().result(gameModel).description("Game Stopped").success(true).build();
		
	}
}
