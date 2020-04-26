package com.roulette.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "casino")
public class Casino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "casino_id", nullable = false, unique = true)
	private long casinoId;
	
	@Column(name= "casino_name", nullable= false)
	private String casinoName;
	
	@Column(name= "balance", nullable= false)
	private double balance;
	
	@OneToMany
	private List<Dealers> dealers = new ArrayList<>();

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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Dealers> getDealers() {
		return dealers;
	}

	public void setDealer(Dealers dealer) {
		this.dealers.add(dealer);
	}
	
	public void removeDealer(Dealers dealer) {
		this.dealers.remove(dealer);
	}
}
