package com.prateek.services;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prateek.enitites.Email;
import com.prateek.enitites.User;
import com.prateek.enitites.UserDTO;
import com.prateek.enitites.UserSession;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.PasswordMismatchException;
import com.prateek.exceptions.UserNotFoundException;

public interface UserService {

	public User registerUser(User user) throws DuplicateUsernameException;
	
	public UserSession loginUser(UserDTO userDetails) throws PasswordMismatchException, UsernameNotFoundException;
	
	public List<Email> getAllMails(String email) throws UserNotFoundException;

	public List<Email> getAllStarredMails(String email) throws UserNotFoundException;
	
	public User updateUser(User user) throws UserNotFoundException ;
	
	
	
}
