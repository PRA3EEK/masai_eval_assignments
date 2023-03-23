package com.prateek.cabApplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.cabApplication.models.Driver;

public interface DriverRepo extends JpaRepository<Driver, Long>{

	public Driver findByUsername(String username);
	
}
