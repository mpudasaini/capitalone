package com.cognizant.demo.util;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.demo.model.Account;
import com.cognizant.demo.model.Customer;
import com.cognizant.demo.repository.AccountRepository;

@Component
public class DataLoader implements CommandLineRunner{
	private AccountRepository accountRepo;
	public DataLoader(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}
	//String accountType, Long accountNumber, Double balance, LocalDate created, LocalDate lastUpdated,
	//String status, Customer customer
	@Override
	public void run(String... args) throws Exception {
		accountRepo.deleteAll();
		Customer customer = new Customer("Mary", "Smith", "123 Main St", "", "Irving", "TX", "75035", LocalDate.now(), LocalDate.now());
		accountRepo.save(new Account("Saving", 12L, 45.00, LocalDate.now(), LocalDate.now(), "active", customer));
		
	}

}
