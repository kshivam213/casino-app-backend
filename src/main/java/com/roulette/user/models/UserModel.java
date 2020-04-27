package com.roulette.user.models;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
	
	private Long userId;
	private Long gameId;
	private String userName;
	private Double balance;
	private String casinoName;
	private List<BetModel> betModels = new ArrayList<BetModel>();
	
	public List<BetModel> getBetModels() {
		return betModels;
	}
	public void setBetModels(List<BetModel> betModels) {
		this.betModels = betModels;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getCasinoName() {
		return casinoName;
	}
	public void setCasinoName(String casinoName) {
		this.casinoName = casinoName;
	}
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
}
