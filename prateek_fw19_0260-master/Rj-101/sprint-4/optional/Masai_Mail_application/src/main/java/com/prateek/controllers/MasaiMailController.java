package com.prateek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.enitites.Email;
import com.prateek.enitites.User;
import com.prateek.enitites.UserDTO;
import com.prateek.enitites.UserSession;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.MailNotFoundException;
import com.prateek.exceptions.PasswordMismatchException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.services.MailService;
import com.prateek.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaimail")
public class MasaiMailController {

	@Autowired
	private UserService userService;
	@Autowired
	private MailService mailService;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid@RequestBody User user) throws DuplicateUsernameException
	{
		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserSession> login(@RequestBody UserDTO userDetails) throws UsernameNotFoundException, PasswordMismatchException
	{
		return new ResponseEntity<UserSession>(userService.loginUser(userDetails), HttpStatus.OK);
	}
	@GetMapping("/mails")
	public ResponseEntity<List<Email>> getAllMails(@RequestParam("emailId") String emailId) throws UserNotFoundException
	{
		return new ResponseEntity<List<Email>>(userService.getAllMails(emailId), HttpStatus.OK);
	}
	
	@GetMapping("/starred")
	public ResponseEntity<List<Email>> getAllStarredEmails(@RequestParam("emailId") String emailId) throws UserNotFoundException
	{
		return new ResponseEntity<List<Email>>(userService.getAllStarredMails(emailId), HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserNotFoundException
	{
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}
	
	@PostMapping("/mail")
	public ResponseEntity<Email> sendEmail(@RequestBody Email email, @RequestParam("emailId") String emailId) throws UserNotFoundException
	{
		return new ResponseEntity<Email>(mailService.sendMail(email, emailId), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{mailId}")
	public ResponseEntity<Email> deleteEmail(@RequestParam("emailId") String emailId, @PathVariable("mailId") Long mailId) throws MailNotFoundException, UserNotFoundException
	{
		return new ResponseEntity<Email>(mailService.deleteAMail(emailId, mailId), HttpStatus.OK);
	}
	@PostMapping("/starred/{mailId}")
	public ResponseEntity<Email> starAEmail(@PathVariable("mailId") Long mailId) throws MailNotFoundException
	{
		return new ResponseEntity<Email>(mailService.starAMail(mailId), HttpStatus.OK);
	}
}   
