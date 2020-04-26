package com.roulette.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dealers")
public class Dealers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dealer_id", nullable = false, unique = true)
	private long dealerId;
	
	@Column(name= "dealer_name", nullable= false)
	private String dealerName;
		
	@OneToOne()
	@JoinColumn(name = "game_id")
	private Games games;
	
}
