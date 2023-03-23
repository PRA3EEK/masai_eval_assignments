package com.prateek.firApplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.firApplication.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
}
