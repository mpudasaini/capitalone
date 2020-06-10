package com.cognizant.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.demo.model.Account;
import com.cognizant.demo.repository.AccountRepository;

@Service
public class AccountService {
	
	private AccountRepository accountRepo;
	
	public AccountService (AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}
	
}
