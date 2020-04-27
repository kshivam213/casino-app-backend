package com.roulette.casino.rest;

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

import com.roulette.casino.interfaces.CasinoInterface;
import com.roulette.casino.models.CasinoModel;
import com.roulette.models.AppResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller related to casino
 * 
 * @author shivam kumar
 */
@RestController
@RequestMapping(value = "/api/v1/casino")
@Slf4j
@CrossOrigin("*")
public class CasinoController {

	private CasinoInterface casinoService;

	@Autowired
	public CasinoController(@Qualifier("casinoService") CasinoInterface casinoService){
		this.casinoService= casinoService;
	}
	
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> addNewCasino(@RequestBody final CasinoModel casinoModel) {
		log.info("Input Json : Add new casino started--");

		AppResponse res = casinoService.registerCasino(casinoModel);
		log.info("Output Json : Connect to user finished-- ");
		return ResponseEntity.ok(res);
	}
	
	@PutMapping(path= "/dealers/add", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> addNewDealer(@RequestBody final CasinoModel casinoModel){
		
		log.info("Input Json : Add new dealer started--");

		AppResponse res = casinoService.addDealers(casinoModel);
		log.info("Output Json : Add new dealer -- ");
		return ResponseEntity.ok(res);
	}
	
	@GetMapping(path= "/dealers/{casinoId}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> listAllDealers(@PathVariable("casinoId") final Long casinoId){
		
		log.info("Input Json : List all dealers --");

		AppResponse res = casinoService.listDealers(casinoId);
		log.info("Output Json : List all dealers -- ");
		return ResponseEntity.ok(res);
	}
	
	@PutMapping(path= "/recharge", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<AppResponse> rechargeCasino(@RequestBody final CasinoModel casinoModel){
			
		log.info("Input Json : Recharge casino --");

		AppResponse res = casinoService.rechargeBalance(casinoModel);
		log.info("Output Json : Recharge Casino end -- ");
		return ResponseEntity.ok(res);
	}
}
