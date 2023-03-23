package com.prateek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prateek.entity.Student;
import com.prateek.repos.StudentRepo;

@Service
public class CustomeUserDetailsService implements UserDetailsService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Student s = studentRepo.findByUsername(username);
		if(s!=null)
		{
			MyUserDetails mud = new MyUserDetails(s);
			return mud;
		}
		throw new UsernameNotFoundException("Username not found");
	}

	
	
}
