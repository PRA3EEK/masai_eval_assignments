package com.prateek.cabApplication.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.cabApplication.DTO.UserDTO;
import com.prateek.cabApplication.exceptions.DriverNotFoundException;
import com.prateek.cabApplication.exceptions.DuplicateUsernameException;
import com.prateek.cabApplication.exceptions.UserNotFoundException;
import com.prateek.cabApplication.models.Driver;
import com.prateek.cabApplication.models.Trip;
import com.prateek.cabApplication.models.User;
import com.prateek.cabApplication.models.UserCurrentSession;
import com.prateek.cabApplication.services.DriverSevice;
import com.prateek.cabApplication.services.UserService;
import java.util.List;
import jakarta.validation.Valid;
import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/masaicab")
public class CabController {

	
	@Autowired
	private DriverSevice driverService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/driver/register")
	public ResponseEntity<Driver> registerDriver(@Valid@RequestBody Driver driver) throws DuplicateUsernameException
	{
		return new ResponseEntity<Driver>(driverService.registerDriver(driver), HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUser(@Valid@RequestBody User user) throws DuplicateUsernameException
	{
		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<UserCurrentSession> loginUser(@RequestBody UserDTO userDetails) throws UserNotFoundException
	{
		return new ResponseEntity<UserCurrentSession>(userService.loginUser(userDetails), HttpStatus.OK);
	}
	
	@GetMapping("/user/findRide")
	public ResponseEntity<List<Driver>> findAllRides(@RequestParam("userId") Long userId) throws UserNotFoundException
	{
		return new ResponseEntity<List<Driver>>(userService.findRides(userId), HttpStatus.OK);
	}
	
	@PostMapping("/user/book/{driverId}/{x-cordinate}/{y-cordinate}")
	public ResponseEntity<Trip> bookATrip(@PathVariable("driverId") Long driverID, @PathVariable("x-cordinate") Integer x, @PathVariable("y-cordinate") Integer y, @RequestBody Trip trip, @RequestParam("userID") Long userId) throws UserNotFoundException, DriverNotFoundException
	{
		return new ResponseEntity<Trip>(userService.bookRide(driverID, x, y, trip, userId), HttpStatus.OK);
	}
}
