package com.roulette.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.dao.GameRepository;
import com.roulette.entity.Games;
import com.roulette.utils.CommonUtils;

@Service
public class GameDaoImpl {

	@Autowired
	private GameRepository gameRepo;

	public Games addGame(final Games game) {

		CommonUtils.preCondition(game == null, "Game can't be null to save");
		return gameRepo.save(game);
	}

	public Games updateGame(final Games game) {

		CommonUtils.preCondition(game == null, "Game can't be null to update");
		CommonUtils.preCondition(game.getGameId() != null, "game Id can't be null for update");

		return gameRepo.save(game);
	}

	public Games findGameById(final long gameId) {

		Games game = gameRepo.findOne(gameId);
		CommonUtils.preCondition(game == null, "Invalid game Id");

		return game;
	}

	public void deleteGame(final Games game) {
		CommonUtils.preCondition(game == null, "Game can't be null to delete");
		gameRepo.delete(game);
	}
}
