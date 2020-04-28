package com.roulette.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "bet")
public class Bet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bet_id", nullable = false, unique = true)
	private Long betId;
	
	@Column(name= "bet_number")
	private Integer betNumber;
	
	@Column(name= "bet_amount")
	private Double betAmount;
	
	@Column(name= "bet_status")
	private boolean betStatus;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Users user;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Games game;
	

	public Long getBetId() {
		return betId;
	}

	public void setBetId(Long betId) {
		this.betId = betId;
	}

	public Integer getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(Integer betNumber) {
		this.betNumber = betNumber;
	}

	public Double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public boolean isBetStatus() {
		return betStatus;
	}

	public void setBetStatus(boolean betStatus) {
		this.betStatus = betStatus;
	}

	public Games getGame() {
		return game;
	}

	public void setGame(Games game) {
		this.game = game;
	}
	
}
