package com.roulette.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.dao.BetRepository;
import com.roulette.entity.Bet;
import com.roulette.utils.CommonUtils;

@Service
public class BetDaoImpl {

	@Autowired
	private BetRepository betRepo;

	public Bet saveBet(Bet bet) {

		CommonUtils.preCondition(bet == null, "Bet object can't be null for save");
		return betRepo.save(bet);
	}

	public Bet updateBet(Bet bet) {

		CommonUtils.preCondition(bet == null, "Can't update null object");
		CommonUtils.preCondition(bet.getBetId() == null, "Id can't be null for updating user");

		return betRepo.save(bet);
	}

	public Bet findBetById(Long betId) {
		Bet bet = betRepo.findOne(betId);
		CommonUtils.preCondition(bet == null, "Invalid Id");

		return bet;
	}

	public void deleteBet(Bet bet) {
		betRepo.delete(bet);
	}

}
