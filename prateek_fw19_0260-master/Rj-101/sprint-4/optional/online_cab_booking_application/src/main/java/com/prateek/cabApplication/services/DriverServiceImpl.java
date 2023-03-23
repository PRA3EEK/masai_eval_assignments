package com.prateek.cabApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.cabApplication.exceptions.DuplicateUsernameException;
import com.prateek.cabApplication.models.Cab;
import com.prateek.cabApplication.models.Driver;
import com.prateek.cabApplication.repos.DriverRepo;

@Service
public class DriverServiceImpl implements DriverSevice{

	@Autowired
	private DriverRepo driverRepo;
	
	@Override
	public Driver registerDriver(Driver driver) throws DuplicateUsernameException {
	
	    if(driverRepo.findByUsername(driver.getUsername()) == null)
	    {
	    	Cab cab = driver.getCab();
	    	cab.setDriver(driver);
	    	return driverRepo.save(driver);
	    }
		throw new DuplicateUsernameException("Username not available");
	}
	
}
