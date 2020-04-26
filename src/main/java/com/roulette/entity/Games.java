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
	private long gameId;
	
	@Column(name= "start_time", nullable= false)
	private long startTime;
	
	@Column(name= "end_time", nullable= false)
	private long endTime;
	
	@Column(name= "status")
	private boolean status;
	
	@Column(name= "thrown_number")
	private int thrownNumber;
	
	@OneToOne(fetch= FetchType.LAZY, mappedBy= "games")
	private Dealers dealer;

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getThrownNumber() {
		return thrownNumber;
	}

	public void setThrownNumber(int thrownNumber) {
		this.thrownNumber = thrownNumber;
	}

	public Dealers getDealer() {
		return dealer;
	}

	public void setDealer(Dealers dealer) {
		this.dealer = dealer;
	}
}
