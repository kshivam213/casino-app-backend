package com.roulette.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roulette.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
}
