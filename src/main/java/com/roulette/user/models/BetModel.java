package com.roulette.user.models;

public class BetModel {
	
	private Long betId;
	private Integer betNumber;
	private Double betAmount;
	private Boolean status;
	private Long gameId;
	
	
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
}
