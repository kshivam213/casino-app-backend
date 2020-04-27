package com.roulette.game.models;

public class GameModel {
	
	private Long dealerId;
	private Long gameId;
	private Long startTime;
	private Long endTime;
	private boolean status;
	private Integer thrownNumber;
	
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
	public Long getDealerId() {
		return dealerId;
	}
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
}
