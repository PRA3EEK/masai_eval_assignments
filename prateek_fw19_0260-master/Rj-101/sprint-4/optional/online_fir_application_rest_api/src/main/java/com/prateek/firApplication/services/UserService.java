package com.prateek.firApplication.services;

import java.util.List;

import com.prateek.firApplication.DTO.UserDTO;
import com.prateek.firApplication.exceptions.DuplicateUsernameException;
import com.prateek.firApplication.exceptions.FirException;
import com.prateek.firApplication.exceptions.IncorrectPasswordException;
import com.prateek.firApplication.exceptions.LoginException;
import com.prateek.firApplication.exceptions.UserNotFoundException;
import com.prateek.firApplication.models.Fir;
import com.prateek.firApplication.models.User;
import com.prateek.firApplication.models.UserCurrentSession;

public interface UserService {

	public User registerUser(User user) throws DuplicateUsernameException;
	
	public UserCurrentSession loginUser(UserDTO userDetails)  throws UserNotFoundException, IncorrectPasswordException, LoginException;
	
	public List<Fir> getAllfirs()  throws UserNotFoundException;
	
	public Fir deleteFir(Long firId)  throws UserNotFoundException, FirException;
	
}
