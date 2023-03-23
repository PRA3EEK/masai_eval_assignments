package com.prateek.firApplication.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.prateek.firApplication.exceptions.UserNotFoundException;
import com.prateek.firApplication.models.Fir;
import com.prateek.firApplication.models.User;
import com.prateek.firApplication.repos.FirRepo;
import com.prateek.firApplication.repos.UserRepo;

import jakarta.validation.ValidationException;

@Service
public class FirServiceImpl implements FirService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private FirRepo firRepo;
	
	@Override
	public Fir fileFir(Fir fir, String userIds) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		User u = userRepo.findByUsername(auth.getName());
		
		String[] arr = userIds.split(",");
		

	    
	    for(String id:arr)
	    {
	      int newid = Integer.parseInt(id);
	    	Optional<User> ou = userRepo.findById((long)newid);
	    	if(!ou.isPresent()) throw new UserNotFoundException("User with id "+id+" is not found");
	    	fir.getFirAgainst().add(ou.get());
	    }
	    
	    u.getFirsFiled().add(fir);
	    fir.setUser(u);
	    fir.setTimeStamp(LocalDateTime.now());
		return firRepo.save(fir);
	}

}
