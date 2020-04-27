package com.roulette.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.dao.CasinoRepository;
import com.roulette.entity.Casino;
import com.roulette.utils.CommonUtils;

@Service("casinoDaoImpl")
public class CasinoDaoImpl {
	
	@Autowired
	private CasinoRepository casinoRepository;
	
	public Casino saveCasino(Casino casino) {
		
		CommonUtils.preCondition(casino == null, "Casino object can't be null for save");
		return casinoRepository.save(casino);
	}
	
	public Casino updateCasino(Casino casino) {
		
		CommonUtils.preCondition(casino == null, "Can't update null object");
		CommonUtils.preCondition(casino.getCasinoId() <= 0, "Id can't be null for updating casino");
		
		return casinoRepository.save(casino);
	}
	
	public Casino findCasinoById(long casinoId) {
		 Casino casino = casinoRepository.findOne(casinoId);
		 CommonUtils.preCondition(casino == null, "Invalid Id");
		 
		 return casino;
	}
	
	public void deleteCasino(Casino casino) {
		casinoRepository.delete(casino);
	}
}
