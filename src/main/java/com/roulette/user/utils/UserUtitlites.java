package com.roulette.user.utils;

import java.util.ArrayList;
import java.util.List;

import com.roulette.entity.Bet;
import com.roulette.entity.Users;
import com.roulette.user.models.BetModel;
import com.roulette.user.models.UserModel;

public class UserUtitlites {
	
	public static UserModel convertUserEntityToModel(Users users) {
		
		UserModel userModel = new UserModel();
		if(users != null) {
			
			if(users.getUserId() != null) {
				userModel.setUserId(users.getUserId());
			}
			if(users.getBalance() != null) {
				userModel.setBalance(users.getBalance());
			}
			if(users.getUserName() != null) {
				userModel.setUserName(users.getUserName());
			}
			if(users.getCashinoName() != null) {
				userModel.setCasinoName(users.getCashinoName());
			}
			
			List<BetModel> betModels = new ArrayList<BetModel>();
			
			for(Bet bet: users.getBets()) {
				BetModel betModel = new BetModel();
				
				betModel.setBetAmount(bet.getBetAmount());
				if(bet.getBetId() != null)
					betModel.setBetId(bet.getBetId());
				betModel.setBetNumber(bet.getBetNumber());
				betModel.setStatus(bet.isBetStatus());
				
				betModels.add(betModel);
			}
			
			userModel.setBetModels(betModels);
		}
		
		return userModel;
	}
}
