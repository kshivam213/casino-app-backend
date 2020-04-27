package com.roulette.game.interfaces;

import com.roulette.models.AppResponse;

public interface GameInterface {
	
	public AppResponse startGame(Long dealerId);
	public AppResponse closeGame(Long dealerId, Long gameId);
	
}
