package com.cognizant.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.cognizant.demo.model.Account;
import com.cognizant.demo.model.AccountSaveResponse;
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

	public Account getAccountById(Long id) {
		Optional<Account> optionalAccount = accountRepo.findById(id);
		optionalAccount.orElseThrow(() -> new EntityNotFoundException("Account with id " + id + " is not found."));
		return optionalAccount.get();
	}

	public AccountSaveResponse addAccount(Account account) {
		Account savedAccount = accountRepo.save(account);
		return new AccountSaveResponse(savedAccount.getAcctId());
	}
	
}
