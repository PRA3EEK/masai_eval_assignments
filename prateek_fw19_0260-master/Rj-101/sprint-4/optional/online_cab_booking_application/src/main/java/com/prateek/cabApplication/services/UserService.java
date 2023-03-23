package com.prateek.cabApplication.services;
import java.util.List;

import com.prateek.cabApplication.DTO.UserDTO;
import com.prateek.cabApplication.exceptions.DriverNotFoundException;
import com.prateek.cabApplication.exceptions.DuplicateUsernameException;
import com.prateek.cabApplication.exceptions.PasswordMismatchException;
import com.prateek.cabApplication.exceptions.UserNotFoundException;
import com.prateek.cabApplication.models.Driver;
import com.prateek.cabApplication.models.Trip;
import com.prateek.cabApplication.models.User;
import com.prateek.cabApplication.models.UserCurrentSession;


public interface UserService {

	public User registerUser(User user) throws DuplicateUsernameException;
	public UserCurrentSession loginUser(UserDTO userDetails) throws UserNotFoundException, PasswordMismatchException;
	public List<Driver> findRides(Long userId) throws UserNotFoundException;
	public Trip bookRide(Long driverId, Integer x_cordinate, Integer y_cordinate, Trip trip, Long userId)throws UserNotFoundException, DriverNotFoundException;
	
}
