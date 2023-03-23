package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUsername(String name);
	
}
