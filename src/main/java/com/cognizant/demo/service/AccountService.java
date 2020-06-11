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

	public Account getAccountById(Long id, Double withdraw, Double deposit) {
		Optional<Account> optionalAccount = accountRepo.findById(id);
		optionalAccount.orElseThrow(() -> new EntityNotFoundException("Account with id " + id + " is not found."));
		Account fromDB = optionalAccount.get();
		if(withdraw != null || deposit != null) {
			Double balance = fromDB.getBalance();
			if(withdraw != null) {
				if(balance.compareTo(withdraw) < 0) {
					throw new EntityNotFoundException("Not enough balance to withdraw from account id " + id);
				}
				fromDB.setBalance(balance - withdraw);
			} else if (deposit != null) {
				fromDB.setBalance(balance + deposit);
			}
			fromDB = accountRepo.save(fromDB);
		}
		return fromDB;
	}

	public AccountSaveResponse addAccount(Account account) {
		Account savedAccount = accountRepo.save(account);
		return new AccountSaveResponse(savedAccount.getAcctId());
	}

	public void deleteAccountById(Long id) {
		accountRepo.deleteById(id);;
	}
	
}
