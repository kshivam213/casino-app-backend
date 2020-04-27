package com.roulette.casino.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.casino.interfaces.CasinoInterface;
import com.roulette.casino.models.CasinoModel;
import com.roulette.casino.models.DealerModel;
import com.roulette.casino.utils.ConversionUtilits;
import com.roulette.daoImpl.CasinoDaoImpl;
import com.roulette.daoImpl.DealerDaoImpl;
import com.roulette.entity.Casino;
import com.roulette.entity.Dealers;
import com.roulette.models.AppResponse;
import com.roulette.utils.CommonUtils;

@Service
public class CasinoService implements CasinoInterface{

	@Autowired
	private CasinoDaoImpl casinoDaoImpl;
	
	@Autowired
	private DealerDaoImpl dealerDaoImpl;
	
	@Override
	public AppResponse registerCasino(CasinoModel casinoModel) {
		
		CommonUtils.preCondition(casinoModel == null, "Casino details can't be null");
		CommonUtils.preCondition(casinoModel.getCasinoName() == null, "Casino Name can't be null");
		CommonUtils.preCondition(casinoModel.getBalance() <= 0, "Initial balance can't be 0");
		
		Casino casino = ConversionUtilits.convertCasinoModelToEntity(casinoModel);
		
		casino = casinoDaoImpl.saveCasino(casino);
		casinoModel= ConversionUtilits.convertCasinoEntityToModel(casino);
		
		return AppResponse.builder().result(casinoModel).success(true).description("Registered Casino").build();
	}

	@Override
	@Transactional
	public AppResponse addDealers(CasinoModel casinoModel) {
		
		CommonUtils.preCondition(casinoModel == null, "Casino details can't be null");
		CommonUtils.preCondition(casinoModel.getCasinoId() == null, "Id can't be null");
		CommonUtils.preCondition(casinoModel.getDealers() == null, "Dealers details can't be null");
		CommonUtils.preCondition(casinoModel.getDealers().isEmpty(), "Dealers is empty");
		
		Casino casino = casinoDaoImpl.findCasinoById(casinoModel.getCasinoId());
		
		for(DealerModel model: casinoModel.getDealers()) {
			Dealers dealer = ConversionUtilits.convertDealerModelToEntity(model);
			dealerDaoImpl.addDealer(dealer);
			
			casino.setDealer(dealer);
		}
		
		casino = casinoDaoImpl.saveCasino(casino);
		casinoModel= ConversionUtilits.convertCasinoEntityToModel(casino);
		
		return AppResponse.builder().result(casinoModel).success(true).description("Dealers added").build();
	}

	@Override
	public AppResponse listDealers(Long casinoId) {
		
		Casino casino = casinoDaoImpl.findCasinoById(casinoId);
		List<DealerModel> listOfDealer = new ArrayList<>();
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		
		for(Dealers dealer: casino.getDealers()) {
			listOfDealer.add(ConversionUtilits.convertDealerEntityToModel(dealer));
		}
		
		result.put("casinoId", casino.getCasinoId());
		result.put("casinoName", casino.getCasinoName());
		result.put("dealers", listOfDealer);
		
		return AppResponse.builder().result(result).success(true).description("List of dealers").build();
	}
	
	@Override
	public AppResponse rechargeBalance(CasinoModel casinoModel) {
		CommonUtils.preCondition(casinoModel.getCasinoId() == null, "Id can't be null");
		CommonUtils.preCondition(casinoModel.getRechargeAmount() == null, "Balance to add can't be null");
		
		Casino casino = casinoDaoImpl.findCasinoById(casinoModel.getCasinoId());
		casino.setBalance(casino.getBalance()+ casinoModel.getRechargeAmount());
		casino = casinoDaoImpl.saveCasino(casino);
		casinoModel= ConversionUtilits.convertCasinoEntityToModel(casino);
		
		return AppResponse.builder().result(casinoModel).success(true).description("Recharged").build();
	}
}
