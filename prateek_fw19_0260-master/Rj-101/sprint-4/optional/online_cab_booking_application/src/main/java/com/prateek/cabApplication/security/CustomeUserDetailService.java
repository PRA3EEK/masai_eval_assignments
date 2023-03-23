package com.prateek.cabApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prateek.cabApplication.models.UserCurrentSession;
import com.prateek.cabApplication.repos.UserSessionRepo;



@Service
public class CustomeUserDetailService implements UserDetailsService{

	@Autowired
	private UserSessionRepo sessionRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserCurrentSession us = sessionRepo.findByUsername(username);
		
		if(us!=null)
		{
			CustomeUserDetails userDetail = new CustomeUserDetails(us);
			return userDetail;
		}
		throw new UsernameNotFoundException("Username not found");
	}

}
