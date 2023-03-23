package com.prateek.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prateek.enitites.Email;
import com.prateek.enitites.User;
import com.prateek.enitites.UserDTO;
import com.prateek.enitites.UserSession;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.PasswordMismatchException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.repos.UserRepo;

import jakarta.validation.ValidationException;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserSessionRepo sessionRepo;
	
	@Override
	public User registerUser(User user) throws DuplicateUsernameException {
		// TODO Auto-generated method stub
		User u = userRepo.findByUsername(user.getUsername());
	if(u==null)
	{
		for(char i='0' ; i<='9' ; i++)
		{
			for(int j=0 ; j<user.getFirstName().length() ; j++)
			{
				if(user.getFirstName().charAt(j) == i)
				{
					throw new ValidationException("firstname or lastname should not contains any numeric value");
				}
			}
		}
		
		for(char i='0' ; i<='9' ; i++)
		{
			for(int j=0 ; j<user.getLastName().length() ; j++)
			{
				if(user.getLastName().charAt(j) == i)
				{
					throw new ValidationException("firstname or lastname should not contains any numeric value");
				}
			}
		}
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(user.getFirstName());
		Matcher m2 = p.matcher(user.getLastName());
		
		if(m.find() || m2.find())
		{
			throw new ValidationException("First name or last name should not contains special characters");
		}
		
		boolean passwordValid = false;
		
		for(char i='0' ; i<='9' ; i++)
		{
			for(int j=0 ; j<user.getPassword().length() ; j++)
			{
				if(user.getPassword().charAt(j) == i)
				{
					passwordValid = true;
				}
			}
		}
		if(!passwordValid)
		{
			throw new ValidationException("Password must contain a numeric value");
		}
		Matcher passwordMatcher = p.matcher(user.getPassword());
		if(!passwordMatcher.find())
		{
			throw new ValidationException("Password must contains a special character");
		}
		
		boolean passwordHasSmallChar = false;
		for(char i='a' ; i<='z' ; i++)
		{
			for(int j=0 ; j<user.getPassword().length() ; j++)
			{
				if((user.getPassword().charAt(j) - i) == 0)
				{
					passwordHasSmallChar = true;
				}
			}
		}
		if(!passwordHasSmallChar)
		{
			throw new ValidationException("Password must contains small case character");
		}
		
		boolean passwordHasCapitalChar = false;
		
		for(char i='A' ; i<='Z' ; i++)
		{
			for(int j=0 ; j<user.getPassword().length() ; j++)
			{
				if((user.getPassword().charAt(j) - i) == 0)
				{
					passwordHasCapitalChar = true;
				}
			}
		}
		
		if(!passwordHasCapitalChar)
		{
			throw new ValidationException("Password must contains a capital letter");
		}
		
		if(!user.getDateOfBirth().isBefore(LocalDateTime.now().toLocalDate()))
		{
			throw new ValidationException("Date of birth must be in past");
		}
		return userRepo.save(user);
	}
	throw new DuplicateUsernameException("Username already present");
	}

	@Override
	public UserSession loginUser(UserDTO userDetails) throws PasswordMismatchException, UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u = userRepo.findByUsername(userDetails.getUsername());
		if(u != null)
		{
			if(u.getPassword().equals(userDetails.getPassword()))
			{
				BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
				
				UserSession us = new UserSession(u.getEmail(), u.getUsername(), bcpe.encode(u.getPassword()), LocalDateTime.now());
			    return sessionRepo.save(us);
			}
			throw new PasswordMismatchException();
		}
		throw new UsernameNotFoundException("User not found with the username "+userDetails.getUsername());
	}

	@Override
	public List<Email> getAllMails(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> ou = userRepo.findById(email);
		
		if(ou.isPresent())
		{
			return ou.get().getMails();
		}
		throw new UserNotFoundException("No user found with the email id "+email);
	}

	@Override
	public List<Email> getAllStarredMails(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
Optional<User> ou = userRepo.findById(email);
		
		if(ou.isPresent())
		{
			List<Email> res = new ArrayList<>();
		    for(Email e:ou.get().getMails())
		    {
		    	if(e.getStarred().equalsIgnoreCase("yes"))
		    	{
		    		res.add(e);
		    	}
		    }
		    return res;
		}
		throw new UserNotFoundException("No user found with the email id "+email);
		
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> ou = userRepo.findById(user.getEmail());
		if(ou.isPresent())
		{
			
		}
	  throw new UserNotFoundException("No user found with the email id "+user.getEmail());
	}

}
