package com.cognizant.demo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.model.Account;
import com.cognizant.demo.model.ErrorResponse;
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
	
	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable Long id){
		return accountService.getAccountById(id);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(EntityNotFoundException ex) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
