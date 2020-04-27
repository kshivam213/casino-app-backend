package com.roulette.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "games")
public class Games {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_id", nullable = false, unique = true)
	private Long gameId;
	
	@Column(name= "start_time")
	private Long startTime;
	
	@Column(name= "end_time")
	private Long endTime;
	
	@Column(name= "status")
	private boolean status;
	
	@Column(name= "thrown_number")
	private Integer thrownNumber;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Dealers dealer;
	
	@OneToMany(mappedBy="game")
	private List<Bet> bets = new ArrayList<>();

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getThrownNumber() {
		return thrownNumber;
	}

	public void setThrownNumber(Integer thrownNumber) {
		this.thrownNumber = thrownNumber;
	}

	public Dealers getDealer() {
		return dealer;
	}

	public void setDealer(Dealers dealer) {
		this.dealer = dealer;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(Bet bets) {
		this.bets.add(bets);
	}
	
	
}
