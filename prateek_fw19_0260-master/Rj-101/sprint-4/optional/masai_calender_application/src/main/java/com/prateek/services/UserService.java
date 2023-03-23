package com.prateek.services;

import java.util.List;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.InvalidTypeException;
import com.prateek.exceptions.PasswordMismatchException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.models.Event;
import com.prateek.models.User;
import com.prateek.models.UserCurrentSession;

import jakarta.validation.ValidationException;

public interface UserService {

	public User userRegister(User user)  throws DuplicateUsernameException, ValidationException;
	
	public UserCurrentSession userLogin(UserDTO userDetails)  throws PasswordMismatchException, UserNotFoundException;
	
	public List<Event>  getAllEventByType(String userId, String type)  throws UserNotFoundException, InvalidTypeException;
	
	public User updateUsernameAndPassword(String userId, String newUsername, String newPassword) throws UserNotFoundException;
	
}
