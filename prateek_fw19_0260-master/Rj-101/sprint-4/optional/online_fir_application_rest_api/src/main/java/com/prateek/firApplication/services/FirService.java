package com.prateek.firApplication.services;

import com.prateek.firApplication.exceptions.UserNotFoundException;
import com.prateek.firApplication.models.Fir;

public interface FirService {

	public Fir fileFir(Fir fir, String userIds)  throws UserNotFoundException;
	
}
