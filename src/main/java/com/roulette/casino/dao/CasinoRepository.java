package com.roulette.casino.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roulette.entity.Casino;

public interface CasinoRepository extends JpaRepository<Casino, Long>{
}
