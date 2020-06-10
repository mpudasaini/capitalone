package com.cognizant.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long acctId;
	private String accountType;
	private Long accountNumber;
	private Double balance;
	private LocalDate created;
	private LocalDate lastUpdated;
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	public Account() {
		super();
	}
	public Account(String accountType, Long accountNumber, Double balance, LocalDate created, LocalDate lastUpdated,
			String status, Customer customer) {
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.created = created;
		this.lastUpdated = lastUpdated;
		this.status = status;
		this.customer = customer;
	}
	public Long getAcctId() {
		return acctId;
	}
	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	public LocalDate getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
}
