package com.prateek.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.UserException;
import com.prateek.models.User;
import com.prateek.models.UserSession;
import com.prateek.repos.UserRepo;
import com.prateek.repos.UserSessionRepo;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private UserSessionRepo sessionRepo;
	
	@Override
	public UserSession userlogin(UserDTO user) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> ou = userRepo.findById(user.getId());
		
		if(ou.isPresent())
		{
			Optional<UserSession> ous = sessionRepo.findById(user.getId());
			if(!ous.isPresent())
			{
				UserSession us = new UserSession(LocalDateTime.now(), user.getId(), user.getUsername(), user.getPassword());
				return sessionRepo.save(us);
			}
			throw new UserException("User is already logged in");
		}
		throw new UserException("Invalid User");

	}

	
	
}
