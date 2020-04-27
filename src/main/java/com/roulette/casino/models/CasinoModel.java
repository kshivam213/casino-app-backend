package com.roulette.casino.models;

import java.util.ArrayList;
import java.util.List;

public class CasinoModel {
	
	private Long casinoId;
	private  String casinoName;
	private List<DealerModel> dealers = new ArrayList<>();
	private Double balance;
	private Double rechargeAmount;
	
	public Long getCasinoId() {
		return casinoId;
	}
	public void setCasinoId(Long casinoId) {
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public void setDealers(List<DealerModel> dealers) {
		this.dealers = dealers;
	}
	
}
