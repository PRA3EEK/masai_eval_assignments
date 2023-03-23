package com.prateek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.entities.Account;
import com.prateek.exceptions.AccountException;
import com.prateek.services.AccountServiceImpl;

@RestController
public class AccountController {

	
	@Autowired
	private AccountServiceImpl asi;
	
	@PostMapping("/account")
	public ResponseEntity<Account> addAccount(@RequestBody Account a) throws AccountException{
		
		return new ResponseEntity<Account>( asi.openAccount(a),HttpStatus.OK);
		
	}
	
	
	
}
