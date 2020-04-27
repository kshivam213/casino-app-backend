package com.roulette.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.models.AppResponse;
import com.roulette.user.interfaces.UserInterface;
import com.roulette.user.models.UserModel;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller related to user
 * 
 * @author shivam kumar
 */
@RestController
@RequestMapping(value = "/api/v1/user")
@Slf4j
@CrossOrigin("*")
public class UserController {
	
	private UserInterface userInterface;

	@Autowired
	public UserController(@Qualifier("userService") UserInterface userInt){
		this.userInterface= userInt;
	}
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> addNewUser(@RequestBody final UserModel userModel) {
		log.info("Input Json : Add new user started--");
		
		AppResponse res = userInterface.registerUser(userModel);
		log.info("Output Json : Add new user finished-- ");
		return ResponseEntity.ok(res);
	}
	
	@PutMapping(path= "/entercasino", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> enterCasino(@RequestBody final UserModel userModel){
		
		log.info("Input Json : Enter casino started--");

		AppResponse res = userInterface.enterCasino(userModel);
		log.info("Output Json : Enter casino finished -- ");
		return ResponseEntity.ok(res);
	}
	
	@PutMapping(path= "/recharge", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> recharge(@RequestBody final UserModel userModel){
		
		log.info("Input Json : Recharge started--");

		AppResponse res = userInterface.enterCasino(userModel);
		log.info("Output Json : Recharge finished -- ");
		return ResponseEntity.ok(res);
	}
	
	@GetMapping(path="/listbets/{userId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> listBets(@PathVariable("userId") final Long userId){
		
		log.info("Input Json : Lists Bet started--");

		AppResponse res = userInterface.listAllBettableGame(userId);
		log.info("Output Json : Lists Bet finished -- ");
		return ResponseEntity.ok(res);
	}
	
	@PutMapping(path= "/betOn", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> betOn(@RequestBody final UserModel userModel){
		
		log.info("Input Json : Bet on started--");

		AppResponse res = userInterface.betOnGame(userModel);
		log.info("Output Json : Bet on finished -- ");
		return ResponseEntity.ok(res);
	}
	
	@GetMapping(path="/cashOut/{userId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> cashOut(@PathVariable("userId") final Long userId){
			
		log.info("Input Json : Lists Bet started--");

		AppResponse res = userInterface.cashOut(userId);
		log.info("Output Json : Lists Bet finished -- ");
		return ResponseEntity.ok(res);
	}
}
