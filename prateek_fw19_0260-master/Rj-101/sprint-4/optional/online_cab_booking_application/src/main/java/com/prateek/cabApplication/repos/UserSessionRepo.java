package com.prateek.cabApplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.cabApplication.models.UserCurrentSession;

public interface UserSessionRepo extends JpaRepository<UserCurrentSession, Long>{

	
	public UserCurrentSession findByUsername(String username);
	
}
