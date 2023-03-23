package com.prateek.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.enitites.UserSession;

public interface UserSessionRepo extends JpaRepository<UserSession, String>{

	public UserSession findByUsername(String username);
	
}
