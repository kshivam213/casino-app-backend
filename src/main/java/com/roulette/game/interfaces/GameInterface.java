package com.roulette.game.interfaces;

import com.roulette.game.models.GameModel;
import com.roulette.models.AppResponse;

public interface GameInterface {
	
	public AppResponse startGame(Long dealerId);
	public AppResponse closeGame(GameModel gameModel);
	
}
