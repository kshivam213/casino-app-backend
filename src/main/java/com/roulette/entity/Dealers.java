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
	private Long dealerId;
	
	@Column(name= "dealer_name", nullable= false)
	private String dealerName;
		
	@OneToOne()
	@JoinColumn(name = "game_id")
	private Games games;

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Games getGames() {
		return games;
	}

	public void setGames(Games games) {
		this.games = games;
	}
}
