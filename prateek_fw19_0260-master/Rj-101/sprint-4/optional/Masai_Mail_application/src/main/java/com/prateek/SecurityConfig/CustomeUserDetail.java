package com.prateek.SecurityConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.prateek.enitites.UserSession;

public class CustomeUserDetail implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserSession userSession;
	
	public CustomeUserDetail(UserSession us)
	{
		this.userSession = us;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority("user");
		grantedAuthorities.add(sga);
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userSession.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userSession.getUsername();
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
