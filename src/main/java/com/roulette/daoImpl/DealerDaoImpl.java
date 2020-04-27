package com.roulette.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.dao.DealerRepository;
import com.roulette.entity.Dealers;
import com.roulette.utils.CommonUtils;

@Service
public class DealerDaoImpl {

	@Autowired
	private DealerRepository dealerRepository;
	
	public Dealers addDealer(final Dealers dealer) {
		
		CommonUtils.preCondition(dealer == null, "Dealer can't be null to save");
		return dealerRepository.save(dealer);
	}
	
	public Dealers updateDealer(final Dealers dealer) {
			
		CommonUtils.preCondition(dealer == null, "Dealer can't be null to update");
		CommonUtils.preCondition(dealer.getDealerId() != null, "Dealer Id can't be null for update");
		
		return dealerRepository.save(dealer);
	}
	
	public Dealers findDealerById(final long dealerId) {
		
		Dealers dealer = dealerRepository.findOne(dealerId);
		CommonUtils.preCondition(dealer == null, "Invalid dealer Id");
		
		return dealer;
	}
	
	public void deleateDealer(final Dealers dealer) {
		CommonUtils.preCondition(dealer == null, "Dealer can't be null to delete");
		dealerRepository.delete(dealer);
	}
}
