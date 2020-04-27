package com.roulette.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roulette.entity.Casino;

@Repository
public interface CasinoRepository extends JpaRepository<Casino, Long>{
	
	Casino findByCasinoName(String casinoName);
}
