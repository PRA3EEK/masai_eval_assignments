package com.prateek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.UserException;
import com.prateek.models.User;
import com.prateek.models.UserSession;
import com.prateek.services.LoginService;
import com.prateek.services.RegisterUserService;

@RestController
public class LoginAndRegisterController {

	@Autowired
	private RegisterUserService registerService;
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody User user) throws DuplicateUsernameException
	{
		return new ResponseEntity<UserDTO>(registerService.register(user), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserSession> loginUser(@RequestBody UserDTO userdto) throws UserException
	{
		return new ResponseEntity<UserSession>(loginService.userlogin(userdto), HttpStatus.OK);
	}
	
}
