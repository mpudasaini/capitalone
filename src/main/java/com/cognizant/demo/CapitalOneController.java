package com.cognizant.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.model.Account;
import com.cognizant.demo.service.AccountService;

@RestController
public class CapitalOneController {
	
	private AccountService accountService;
	
	public CapitalOneController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccount(){
		return accountService.getAllAccounts();
	}
}
