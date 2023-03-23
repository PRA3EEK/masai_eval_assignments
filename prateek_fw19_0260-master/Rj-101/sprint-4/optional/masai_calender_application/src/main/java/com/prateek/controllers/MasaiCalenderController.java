package com.prateek.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.EventNotFoundException;
import com.prateek.exceptions.InvalidDateException;
import com.prateek.exceptions.InvalidTypeException;
import com.prateek.exceptions.PasswordMismatchException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.models.Event;
import com.prateek.models.User;
import com.prateek.models.UserCurrentSession;
import com.prateek.services.EventService;
import com.prateek.services.UserService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/masaicalender")
public class MasaiCalenderController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws ValidationException, DuplicateUsernameException
	{
		return new ResponseEntity<User>(userService.userRegister(user), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserCurrentSession> loginUser(@RequestBody UserDTO userDetails) throws PasswordMismatchException, UserNotFoundException
	{
		return new ResponseEntity<UserCurrentSession>(userService.userLogin(userDetails), HttpStatus.OK);
	}
   
	@GetMapping("/event/{type}")
	public ResponseEntity<List<Event>> getAllEventsByType(@RequestParam("userId") String userId, @PathVariable("type") String type) throws UserNotFoundException, InvalidTypeException{
		return new ResponseEntity<List<Event>>(userService.getAllEventByType(userId, type), HttpStatus.OK);
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUsernameAndPassword(@PathVariable("userId") String id, @RequestParam("newUsername") String username, @RequestParam("newPassword") String password) throws UserNotFoundException
	{
		return new ResponseEntity<User>(userService.updateUsernameAndPassword(id, username, password), HttpStatus.OK);
	}
    
	@PostMapping("/event")
	public ResponseEntity<Event> addEvent(@RequestBody Event event, @RequestParam("userId") String userId) throws UserNotFoundException, InvalidDateException
	{
		return new ResponseEntity<Event>(eventService.addEvent(event, userId), HttpStatus.CREATED);
	}
	
	@PutMapping("/event/{eventId}")
	public ResponseEntity<Event> updateEvent (@RequestBody Event event, @PathVariable("eventId") Long eventId) throws EventNotFoundException
	{
	return new ResponseEntity<Event>(eventService.updateEvent(event, eventId), HttpStatus.OK);	
	}
	
}
