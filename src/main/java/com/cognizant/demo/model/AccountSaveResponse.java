package com.cognizant.demo.model;

public class AccountSaveResponse {
	private Long acctId;

	public AccountSaveResponse() {
		super();
	}

	public AccountSaveResponse(Long acctId) {
		this.acctId = acctId;
	}

	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}
	
}
