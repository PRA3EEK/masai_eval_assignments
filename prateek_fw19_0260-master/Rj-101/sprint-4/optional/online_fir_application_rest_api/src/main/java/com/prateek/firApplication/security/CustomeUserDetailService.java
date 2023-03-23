package com.prateek.firApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prateek.firApplication.models.UserCurrentSession;
import com.prateek.firApplication.repos.CurrentSessionRepo;




@Service
public class CustomeUserDetailService implements UserDetailsService{

	@Autowired
	private CurrentSessionRepo sessionRepo;
	
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
