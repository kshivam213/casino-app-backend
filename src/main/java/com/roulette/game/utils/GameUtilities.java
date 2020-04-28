package com.roulette.game.utils;

import com.roulette.entity.Games;
import com.roulette.game.models.GameModel;

public class GameUtilities {
	
	public static GameModel convertGameEntityToModel(Games game, Long dealerId) {
		
		GameModel gameModel = new GameModel();
		if(game.getGameId() != null)
			gameModel.setGameId(game.getGameId());
		
		if(dealerId != null) {
			gameModel.setDealerId(dealerId);
		}
		
		gameModel.setStatus(game.isStatus());
		if(game.getStartTime() != null)
			gameModel.setStartTime(game.getStartTime());
		
		if(game.getEndTime() != null)
			gameModel.setEndTime(game.getEndTime());
		
		if(game.getThrownNumber() != null)
			gameModel.setThrownNumber(game.getThrownNumber());
		
		return gameModel;
	}
}
