package com.roulette.game.services;

import java.time.Instant;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.daoImpl.DealerDaoImpl;
import com.roulette.daoImpl.GameDaoImpl;
import com.roulette.entity.Dealers;
import com.roulette.entity.Games;
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

	@Override
	public AppResponse startGame(Long dealerId) {
		
		Dealers dealer= dealerRepo.findDealerById(dealerId);
		Games game= new Games();
		game.setDealer(dealer);
		game.setStartTime(Instant.now().getEpochSecond());
		game.setStatus(true);
		
		game= gameRepo.addGame(game);
		
		GameModel gameModel = GameUtilities.convertGameEntityToModel(game, dealerId);
		return AppResponse.builder().result(gameModel).description("Game Started").success(true).build();
	}

	@Override
	public AppResponse closeGame(Long dealerId, Long gameId) {
		
		Games game= gameRepo.findGameById(gameId);
        CommonUtils.preCondition(game.getDealer().getDealerId() != dealerId, "Invalid Dealer");
		
		Random rand = new Random(); 

		game.setStatus(false);
		game.setEndTime(Instant.now().getEpochSecond());
		game.setThrownNumber(rand.nextInt()+1);
		
		game = gameRepo.addGame(game);
		
		GameModel gameModel = GameUtilities.convertGameEntityToModel(game, dealerId);
		return AppResponse.builder().result(gameModel).description("Game Stopped").success(true).build();
	
	}
}
