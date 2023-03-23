package com.prateek.services;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.models.User;

public interface RegisterUserService {

	
	public UserDTO register(User user) throws DuplicateUsernameException;
	
}
