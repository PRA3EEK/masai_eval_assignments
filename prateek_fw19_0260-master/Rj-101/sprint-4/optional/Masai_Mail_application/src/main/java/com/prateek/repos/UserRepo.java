package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.enitites.User;

public interface UserRepo extends JpaRepository<User, String>{

	public User findByUsername(String username);
	
}
