package com.prateek.firApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.firApplication.DTO.UserDTO;
import com.prateek.firApplication.exceptions.DuplicateUsernameException;
import com.prateek.firApplication.exceptions.FirException;
import com.prateek.firApplication.exceptions.IncorrectPasswordException;
import com.prateek.firApplication.exceptions.LoginException;
import com.prateek.firApplication.exceptions.UserNotFoundException;
import com.prateek.firApplication.models.Fir;
import com.prateek.firApplication.models.User;
import com.prateek.firApplication.models.UserCurrentSession;
import com.prateek.firApplication.services.FirService;
import com.prateek.firApplication.services.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/masaifir")
public class FirController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FirService firService;
     
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws DuplicateUsernameException
	{
		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<UserCurrentSession> loginUser(@RequestBody UserDTO userDetails) throws UserNotFoundException, IncorrectPasswordException, LoginException
	{
		return new ResponseEntity<UserCurrentSession>(userService.loginUser(userDetails), HttpStatus.OK);
	}
	@GetMapping("/user/fir")
	public ResponseEntity<List<Fir>> getAllFirs() throws UserNotFoundException
	{
	  return new ResponseEntity<List<Fir>>(userService.getAllfirs(), HttpStatus.OK);	
	}
	
	
	@DeleteMapping("/user/fir/{firId}")
	public ResponseEntity<Fir> deleteFir(@PathVariable("firId") Long firId) throws UserNotFoundException, FirException 
	{
		return new ResponseEntity<Fir>(userService.deleteFir(firId), HttpStatus.OK);
	}
	//to file complaint against multiple users at once pass the multiple user ids seperated by commas through request param otherwise just pass the single user id
	@PostMapping("/user/fir")
	public ResponseEntity<Fir> registerFir(@RequestBody Fir fir, @RequestParam("against") String ids) throws UserNotFoundException
	{
		return new ResponseEntity<Fir>(firService.fileFir(fir, ids), HttpStatus.CREATED);
	}
	
}
