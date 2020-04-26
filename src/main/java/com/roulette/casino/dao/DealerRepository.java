package com.roulette.casino.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roulette.entity.Dealers;

public interface DealerRepository extends JpaRepository<Dealers, Long>{
}