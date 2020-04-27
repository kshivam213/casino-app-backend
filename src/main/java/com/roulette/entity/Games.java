package com.roulette.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Games {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_id", nullable = false, unique = true)
	private Long gameId;
	
	@Column(name= "start_time", nullable= false)
	private Long startTime;
	
	@Column(name= "end_time", nullable= false)
	private Long endTime;
	
	@Column(name= "status")
	private boolean status;
	
	@Column(name= "thrown_number")
	private Integer thrownNumber;
	
	@OneToOne(fetch= FetchType.LAZY, mappedBy= "games")
	private Dealers dealer;

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
	
	
}
