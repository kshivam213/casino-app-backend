package com.roulette.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roulette.entity.Dealers;

@Repository
public interface DealerRepository extends JpaRepository<Dealers, Long>{
}