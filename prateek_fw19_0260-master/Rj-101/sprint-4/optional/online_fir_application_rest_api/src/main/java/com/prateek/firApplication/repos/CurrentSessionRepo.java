package com.prateek.firApplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.firApplication.models.UserCurrentSession;

public interface CurrentSessionRepo extends JpaRepository<UserCurrentSession, Long>{

	
	public UserCurrentSession findByUsername(String username);
}
