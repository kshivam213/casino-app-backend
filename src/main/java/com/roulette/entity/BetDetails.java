package com.roulette.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "bet")
public class BetDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bet_id", nullable = false, unique = true)
	private long betId;
	
	@Column(name= "bet_number")
	private int betNumber;
	
	@Column(name= "bet_amount")
	private double betAmount;
	
}
