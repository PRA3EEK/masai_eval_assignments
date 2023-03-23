package com.prateek.services;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.UserException;
import com.prateek.models.UserSession;

public interface LoginService {

	public UserSession userlogin(UserDTO user) throws UserException;
	
}
