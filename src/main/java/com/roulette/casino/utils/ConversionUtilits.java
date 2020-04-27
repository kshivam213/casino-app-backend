package com.roulette.casino.utils;

import java.util.ArrayList;
import java.util.List;

import com.roulette.casino.models.CasinoModel;
import com.roulette.casino.models.DealerModel;
import com.roulette.entity.Casino;
import com.roulette.entity.Dealers;

public class ConversionUtilits {

	public static Casino convertCasinoModelToEntity(final CasinoModel casinoModel) {
		
		Casino casino = new Casino();
		
		if(casinoModel.getCasinoId() != null)
			casino.setCasinoId(casinoModel.getCasinoId());
		if(casinoModel.getCasinoName() != null)
			casino.setCasinoName(casinoModel.getCasinoName());
		if(casinoModel.getBalance() != null)
			casino.setBalance(casinoModel.getBalance());
		if(casinoModel.getDealers() != null) {
			
			for(DealerModel model : casinoModel.getDealers()) {
				casino.setDealer(convertDealerModelToEntity(model));
			}
		}
		
		return casino;
	}
	
	public static Dealers convertDealerModelToEntity(final DealerModel dealerModel) {
		
		Dealers dealer = new Dealers();
		if(dealerModel.getDealerId() != null)
			dealer.setDealerId(dealerModel.getDealerId());
		if(dealerModel.getDealerName() != null)
			dealer.setDealerName(dealerModel.getDealerName());
		
		return dealer;
	}
	
	public static CasinoModel convertCasinoEntityToModel(final Casino casino) {
		
		CasinoModel casinoModel = new CasinoModel();
		if(casino.getCasinoId() != null )
			casinoModel.setCasinoId(casino.getCasinoId());
		casinoModel.setBalance(casino.getBalance());
		casinoModel.setCasinoName(casino.getCasinoName());
		
		List<DealerModel> dealerList = new ArrayList<DealerModel>();
		
		if(casino.getDealers() != null) {
			for(Dealers dealer: casino.getDealers()) {
				dealerList.add(convertDealerEntityToModel(dealer));
			}
		}
		casinoModel.setDealers(dealerList);
		
		return casinoModel;
	}
	
	public static DealerModel convertDealerEntityToModel(final Dealers dealer) {
		
		DealerModel dealerModel = new DealerModel();
		dealerModel.setDealerId(dealer.getDealerId());
		dealerModel.setDealerName(dealer.getDealerName());
		
		return dealerModel;
	}
}
