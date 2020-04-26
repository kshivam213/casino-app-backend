package com.roulette.casino.models;

import java.util.List;

public class CasinoModel {
	
	private long casinoId;
	private  String casinoName;
	private List<DealerModel> dealers;
	private double balance;
	
	public long getCasinoId() {
		return casinoId;
	}
	public void setCasinoId(long casinoId) {
		this.casinoId = casinoId;
	}
	public String getCasinoName() {
		return casinoName;
	}
	public void setCasinoName(String casinoName) {
		this.casinoName = casinoName;
	}
	public List<DealerModel> getDealers() {
		return dealers;
	}
	public void setDealers(List<DealerModel> dealers) {
		this.dealers = dealers;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
