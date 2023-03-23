package com.prateek.services;

import com.prateek.enitites.Email;
import com.prateek.exceptions.MailNotFoundException;
import com.prateek.exceptions.UserNotFoundException;

public interface MailService {

	
     public Email sendMail(Email email, String emailId) throws UserNotFoundException;
	
	public Email starAMail(Long mailId) throws MailNotFoundException;
	
	public Email deleteAMail(String email, Long mailId) throws MailNotFoundException, UserNotFoundException;
	
}
