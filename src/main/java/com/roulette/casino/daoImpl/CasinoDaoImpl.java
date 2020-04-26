package com.roulette.casino.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.casino.dao.CasinoRepository;

@Service
public class CasinoDaoImpl {
	
	@Autowired
	private CasinoRepository casinoRepository;
	
}
