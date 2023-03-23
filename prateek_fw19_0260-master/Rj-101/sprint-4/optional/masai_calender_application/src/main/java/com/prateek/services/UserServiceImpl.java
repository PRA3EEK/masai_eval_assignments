package com.prateek.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prateek.DTO.UserDTO;
import com.prateek.exceptions.DuplicateUsernameException;
import com.prateek.exceptions.InvalidTypeException;
import com.prateek.exceptions.PasswordMismatchException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.models.Event;
import com.prateek.models.User;
import com.prateek.models.UserCurrentSession;
import com.prateek.repos.UserRepo;
import com.prateek.repos.UserSessionRepo;

import jakarta.validation.ValidationException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserSessionRepo userSession;
	
	@Override
	public User userRegister(User user) throws DuplicateUsernameException, ValidationException {
		// TODO Auto-generated method stub
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String username = user.getUsername();
		String password = user.getPassword();
		
		for(char i='0' ; i<'9' ; i++)
		{
			for(int j=0 ; j<firstName.length() ; j++)
			{
				if(firstName.charAt(j) == i)
				{
					throw new ValidationException("First name of the user must not contain any numeric values");
				}
			}
		}
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(firstName);
		
		if(m.find())
		{
			throw new ValidationException("First name of the user must not contains any special characters");
		}
		
		
		for(char i='0' ; i<'9' ; i++)
		{
			for(int j=0 ; j<lastName.length() ; j++)
			{
				if(lastName.charAt(j) == i)
				{
					throw new ValidationException("Last name of the user must not contain any numeric values");
				}
			}
		}
		
	
		Matcher m2 = p.matcher(lastName);
		
		if(m2.find())
		{
			throw new ValidationException("Last name of the user must not contains any special characters");
		}
		
		boolean containsUpperCaseLetter = false;
		boolean containsLowerCaseLetter = false;
		boolean containsNumericValue = false;
		
		for(char i='a' ; i<='z' ; i++)
		{
			if(containsLowerCaseLetter)
			{
				break;
			}
			for(int j=0 ; j<password.length() ; j++)
			{
				if(password.charAt(j)-i == 0)
				{
					containsLowerCaseLetter = true;
					break;
				}
			}
		}
		
		if(!containsLowerCaseLetter)
		{
			throw new ValidationException("Password must contain a lower case letter");
		}
		
		for(char i='A' ; i<='Z' ; i++)
		{
			if(containsUpperCaseLetter)
			{
				break;
			}
			for(int j=0 ; j<password.length() ; j++)
			{
				if(password.charAt(j)-i == 0)
				{
					containsUpperCaseLetter = true;
					break;
				}
			}
		}
		
		if(!containsUpperCaseLetter)
		{
			throw new ValidationException("Password must contains an upper case letter");
		}
		
		Matcher pasMatcher = p.matcher(password);
		if(!pasMatcher.find())
		{
			throw new ValidationException("Password must contains a special character");
		}
		
		for(char i='0' ; i<='9' ; i++)
		{
			if(containsNumericValue)
			{
				break;
			}
			for(int j=0 ; j<password.length() ; j++)
			{
				if(password.charAt(j) == i)
				{
				   containsNumericValue = true;
				   break;
				}
			}
		}
		if(!containsNumericValue)
		{
			throw new ValidationException("Password must contains a numeric value");
		}
		
		if(userRepo.findByUsername(username)!=null)
		{
			throw new DuplicateUsernameException("username not available");
		}
		
		return userRepo.save(user);
	}

	@Override
	public UserCurrentSession userLogin(UserDTO userDetails) throws PasswordMismatchException, UserNotFoundException {
		// TODO Auto-generated method stub
		User u = userRepo.findByUsername(userDetails.getUsername());
		if(u != null)
		{
			if(u.getPassword().equals(userDetails.getPassword()))
			{
				BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
				
				UserCurrentSession us = new UserCurrentSession(UUID.randomUUID().toString(), u.getEmail(), u.getUsername(), bcpe.encode(u.getPassword()), LocalDateTime.now());
			    return userSession.save(us);
			}
			throw new PasswordMismatchException("Incorrect password");
		}
		throw new UserNotFoundException("User not found with the username "+userDetails.getUsername());
	}

	@Override
	public List<Event> getAllEventByType(String userId, String type) throws UserNotFoundException, InvalidTypeException {
		// TODO Auto-generated method stub
		
	  Optional<User> ou = userRepo.findById(userId);
	  
	  if(ou.isPresent())
	  {
		List<Event> events = ou.get().getEvents();
		List<Event> res = new ArrayList<>();
		if(type.equalsIgnoreCase("month"))
		{			
			Month curMonth = LocalDateTime.now().toLocalDate().getMonth();
			int curYear = LocalDateTime.now().toLocalDate().getYear();
			for(Event e:events)
			{
				if(e.getStartTime().toLocalDate().getMonth() == curMonth && e.getStartTime().toLocalDate().getYear() == curYear);
				{
					res.add(e);
				}
			}
		}
		
		else if(type.equalsIgnoreCase("day"))
		{
			LocalDate today =  LocalDateTime.now().toLocalDate();
			for(Event e:events)
			{
				if(e.getStartTime().toLocalDate() == today)
				{
					res.add(e);
				}
			}
		}
		else if(type.equalsIgnoreCase("week"))
		{
			
		}
		else
		{
			throw new InvalidTypeException("Type must be week, day, month");
		}
		return res;
	  }
	 throw new UserNotFoundException("No user found");	
		
	}

	@Override
	public User updateUsernameAndPassword(String userId, String newUsername, String newPassword) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> ou =  userRepo.findById(userId);
	    
		if(ou.isPresent())
		{
			User u = ou.get();
			u.setUsername(newUsername);
			u.setPassword(newPassword);
			userRepo.save(u);
		}
		
		throw new UserNotFoundException("User not found");
	} 

}
