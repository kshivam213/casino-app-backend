package com.roulette.game.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.game.interfaces.GameInterface;
import com.roulette.game.models.GameModel;
import com.roulette.models.AppResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller related to game
 * 
 * @author shivam kumar
 */
@RestController
@RequestMapping(value = "/api/v1/game")
@Slf4j
@CrossOrigin("*")
public class GameController {
	
	private GameInterface gameInterface;

	@Autowired
	public GameController(@Qualifier("gameService") GameInterface gameInt){
		this.gameInterface= gameInt;
	}
	
	@GetMapping(path="/start/{dealerId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> startGame(@PathVariable("dealerId") final Long dealerId){
		
		log.info("Input Json : Start Game started--");

		AppResponse res = gameInterface.startGame(dealerId);
		log.info("Output Json : Start game finished -- ");
		return ResponseEntity.ok(res);
	}
	
	@PutMapping(path="/end", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> closeGame(@RequestBody final GameModel gameModel){
		
		log.info("Input Json : End game started--");

		AppResponse res = gameInterface.closeGame(gameModel);
		log.info("Output Json : End game finished -- ");
		return ResponseEntity.ok(res);
	}
}
