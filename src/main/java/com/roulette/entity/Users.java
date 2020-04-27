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
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long userId;
	
	@Column(name= "user_name", nullable= false)
	private String userName;
	
	@Column(name= "balance", nullable= false)
	private Double balance;
	
	@Column(name= "casino_name")
	private String cashinoName;
	
	@OneToMany
	private List<Bet> bets = new ArrayList<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBet(Bet bet) {
		this.bets.add(bet);
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

	public String getCashinoName() {
		return cashinoName;
	}

	public void setCashinoName(String cashinoName) {
		this.cashinoName = cashinoName;
	}
}
