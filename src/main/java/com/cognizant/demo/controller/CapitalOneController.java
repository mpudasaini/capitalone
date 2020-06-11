package com.cognizant.demo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cognizant.demo.model.Account;
import com.cognizant.demo.model.AccountSaveResponse;
import com.cognizant.demo.model.ErrorResponse;
import com.cognizant.demo.service.AccountService;

@RestController
@EnableWebMvc
public class CapitalOneController {
	
	private AccountService accountService;
	
	private static Logger log = LoggerFactory.getLogger(CapitalOneController.class);
	
	public CapitalOneController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccount(){
		log.info("####Called Accounts########");
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable Long id,
								  @RequestParam(value = "withdraw", required=false) Double withdraw,
								  @RequestParam(value = "deposit", required=false) Double deposit){
		log.info("######Called Account By Id########");
		return accountService.getAccountById(id, withdraw, deposit);
	}
	
	@PostMapping("/accounts")
	public AccountSaveResponse AddAccount(@RequestBody Account account){
		log.info("#######Called Account Save#########");
		return accountService.addAccount(account);
	}
	
	@DeleteMapping("/account/{id}")
	public void deleteAccountById(@PathVariable Long id){
		log.info("###########Called Delete Account By Id##########");
		accountService.deleteAccountById(id);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
		log.error(ex.getMessage());
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(EntityNotFoundException ex) {
		log.error(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
