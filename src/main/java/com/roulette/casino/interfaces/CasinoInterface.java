package com.roulette.casino.interfaces;

import org.springframework.stereotype.Component;

import com.roulette.casino.models.CasinoModel;
import com.roulette.models.AppResponse;

@Component
public interface CasinoInterface {
	
	public AppResponse registerCasino(final CasinoModel casinoModel);
	public AppResponse addDealers(final CasinoModel casinoModel);
	public AppResponse listDealers(final Long casinoId);
	public AppResponse rechargeBalance(final CasinoModel casinoModel);
}
