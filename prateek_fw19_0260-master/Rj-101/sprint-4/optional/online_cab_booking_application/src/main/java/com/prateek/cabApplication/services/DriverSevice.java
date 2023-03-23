package com.prateek.cabApplication.services;

import com.prateek.cabApplication.exceptions.DuplicateUsernameException;
import com.prateek.cabApplication.models.Driver;

public interface DriverSevice {

	public Driver registerDriver(Driver driver) throws DuplicateUsernameException;
	
	
	
	
}
