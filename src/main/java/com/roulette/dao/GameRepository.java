package com.roulette.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roulette.entity.Games;

@Repository
public interface GameRepository extends JpaRepository<Games, Long>{
}