package com.roulette.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roulette.entity.Bet;

public interface BetRepository extends JpaRepository<Bet, Long>{
}
