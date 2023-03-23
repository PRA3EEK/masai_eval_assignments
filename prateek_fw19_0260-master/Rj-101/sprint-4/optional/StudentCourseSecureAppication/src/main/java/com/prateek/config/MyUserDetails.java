package com.prateek.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.prateek.entity.Student;


public class MyUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Student student;
	
	public MyUserDetails(Student student) {
		this.student = student;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		SimpleGrantedAuthority simpleGrantedAuthorities = new SimpleGrantedAuthority(student.getRole());
		grantedAuthorities.add(simpleGrantedAuthorities);
		
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return student.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
