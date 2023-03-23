package com.prateek.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.enitites.Email;
import com.prateek.enitites.User;
import com.prateek.exceptions.MailNotFoundException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.repos.EmailRepo;
import com.prateek.repos.UserRepo;

@Service
public class MailServiceImpl implements MailService{
   
	@Autowired
	private UserRepo userRepo;
    
	@Autowired
	private EmailRepo emailRepo;
	
	@Override
	public Email sendMail(Email email, String emailId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> ou = userRepo.findById(emailId);
		
		 if(ou.isPresent())
		 {
			 
			 if(userRepo.findById(email.getSendTo()).isPresent())
			 {
				 
				 User u = userRepo.findById(emailId).get();
				 u.getMails().add(email);
				 email.setUser(u);
			     userRepo.save(u);
			     return emailRepo.save(email);
			 }
			 throw new UserNotFoundException("The email id to which you are trying to send this mail is invalid");
		 }
		
		throw new UserNotFoundException("User not found having emailId "+emailId);
	}

	@Override
	public Email starAMail(Long generatedMailId) throws MailNotFoundException {
		// TODO Auto-generated method stub
		Optional<Email> oe =  emailRepo.findById(generatedMailId);
		if(oe.isPresent()) {
			Email e = oe.get();
			e.setStarred("yes");
			return emailRepo.save(e);
		}
		throw new MailNotFoundException("Mail not found with the id "+generatedMailId);
	}

	@Override
	public Email deleteAMail(String emailId, Long generatedMailId) throws MailNotFoundException, UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> emailOptional =  userRepo.findById(emailId);
		if(emailOptional.isPresent())
		{
			User user = emailOptional.get();
			Email email = null;
			for(Email e:user.getMails())
			{
				if(e.getGeneratedEmailId() == generatedMailId)
				{
					email = e;
					break;
				}
			}
			if(email!=null)
			{
				
				emailRepo.delete(email);
				return email;
			}
			throw new MailNotFoundException("Mail not found with the id "+generatedMailId);
		}
		throw new UserNotFoundException("No user found with the email id "+emailId);
	}

}
