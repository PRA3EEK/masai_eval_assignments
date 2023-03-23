package com.prateek.cabApplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.cabApplication.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
}
