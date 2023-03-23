package com.prateek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.models.User;
import com.prateek.repos.UserRepo;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{

	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public UserDTO register(User user) throws DuplicateUsernameException {
		// TODO Auto-generated method stub
		User u = userRepo.findByUsername(user.getUsername());
		if(u == null)
		{
			 userRepo.save(user);
			 UserDTO ud = new UserDTO(user.getId(), user.getUsername(), user.getPassword());
		      return ud;
		}
		
        throw new DuplicateUsernameException("User already present with the username "+user.getUsername());
	}

}
