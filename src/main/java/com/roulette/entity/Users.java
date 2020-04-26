package com.roulette.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false, unique = true)
	private long dealerId;
	
	@Column(name= "user_name", nullable= false)
	private String userName;
	
	@Column(name= "balance", nullable= false)
	private double balance;
	
	@Column(name= "cashino_name", nullable= false)
	private String cashinoName;

	public long getDealerId() {
		return dealerId;
	}

	public void setDealerId(long dealerId) {
		this.dealerId = dealerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCashinoName() {
		return cashinoName;
	}

	public void setCashinoName(String cashinoName) {
		this.cashinoName = cashinoName;
	}
}
