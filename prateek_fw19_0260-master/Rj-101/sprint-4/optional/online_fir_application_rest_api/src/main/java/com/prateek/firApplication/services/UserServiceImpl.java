package com.prateek.firApplication.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prateek.firApplication.DTO.UserDTO;
import com.prateek.firApplication.exceptions.DuplicateUsernameException;
import com.prateek.firApplication.exceptions.FirException;
import com.prateek.firApplication.exceptions.IncorrectPasswordException;
import com.prateek.firApplication.exceptions.LoginException;
import com.prateek.firApplication.exceptions.UserNotFoundException;
import com.prateek.firApplication.models.Fir;
import com.prateek.firApplication.models.User;
import com.prateek.firApplication.models.UserCurrentSession;
import com.prateek.firApplication.repos.CurrentSessionRepo;
import com.prateek.firApplication.repos.FirRepo;
import com.prateek.firApplication.repos.UserRepo;

import jakarta.security.auth.message.config.AuthConfig;
import jakarta.validation.ValidationException;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CurrentSessionRepo sessionRepo;
	
	@Autowired
	private FirRepo firRepo;
	
	@Override
	public User registerUser(User user) throws DuplicateUsernameException {
		// TODO Auto-generated method stub
		
		User u = userRepo.findByUsername(user.getUsername());
		
		if(u == null)
		{
			String firstname = user.getFirstName();
			String lastname = user.getLastName();
			String password = user.getPassword();
			
			Pattern p = Pattern.compile("[^a-z0-9 ]");
			
			for(char i='0'; i<='9'; i++)
			{
				for(int j=0; j<firstname.length() ; j++)
				{
					if(firstname.charAt(j) == i) throw new ValidationException("First name must not contain any numeric values");
				}
			}
			Matcher firstnameMatcher = p.matcher(firstname);
			if(firstnameMatcher.find()) throw new ValidationException("First name must not contain any special character");
			
			for(char i='0'; i<='9'; i++)
			{
				for(int j=0; j<lastname.length() ; j++)
				{
					if(lastname.charAt(j) == i) throw new ValidationException("Last name must not contain any numeric values");
				}
			}
			Matcher lastnameMatcher = p.matcher(lastname);
			if(lastnameMatcher.find()) throw new ValidationException("Last name must not contain any special character");
			
			boolean passwordContainsUppercase = false;
			boolean passwordContainsLowercase = false;
			boolean passwordCoontainsNumeric = false;
			
			for(char i='A'; i<='Z'; i++)
			{
				if(passwordContainsUppercase) break;
				for(int j=0; j<password.length(); j++)
				{
					if(password.charAt(j) - i == 0) {passwordContainsUppercase = true; break;}
				}
			}
			if(!passwordContainsUppercase) throw new ValidationException("Password must contains an upper case letter");
			for(char i='a'; i<='z'; i++)
			{
				if(passwordContainsLowercase) break;
				for(int j=0; j<password.length(); j++)
				{
					if(password.charAt(j) - i == 0) {passwordContainsLowercase = true; break;}
				}
			}
			if(!passwordContainsLowercase) throw new ValidationException("Password must contains an lower case letter");
			
			for(char i='0'; i<='9' ; i++)
			{
				if(passwordCoontainsNumeric) break;
				for(int j=0 ; j<password.length(); j++)
				{
					if(password.charAt(j) == i) {passwordCoontainsNumeric = true; break;}
				}
			}
			if(!passwordCoontainsNumeric) throw new ValidationException("Password must contains a numeric value");
			
			Matcher pasMatcher = p.matcher(password);
			if(!pasMatcher.find()) throw new ValidationException("Password must contain a special character");
			
			if(user.getAge()<=8) throw new ValidationException("Age of the user must be above 8 years");
			
			if(user.getGender().equalsIgnoreCase("male") || user.getGender().equalsIgnoreCase("female") || user.getGender().equalsIgnoreCase("other"))
			    return userRepo.save(user);
		
			throw new ValidationException("Enter a valid gender among (male / female / other)");
		}
		
		throw new DuplicateUsernameException("Username not available");
	}

	@Override
	public UserCurrentSession loginUser(UserDTO userDetails) throws UserNotFoundException, IncorrectPasswordException, LoginException {
		// TODO Auto-generated method stub
		User u =  userRepo.findByUsername(userDetails.getUsername());
		UserCurrentSession ucs = sessionRepo.findByUsername(userDetails.getUsername());
		if(ucs == null)
		{
			
			if(u != null) {
				if(u.getPassword().equals(userDetails.getPassword()))
				{
					
					UserCurrentSession newSession = new UserCurrentSession(u.getId(), u.getUsername(), new BCryptPasswordEncoder().encode(u.getPassword()) , UUID.randomUUID().toString());
					return sessionRepo.save(newSession);
				}
				throw new IncorrectPasswordException("Password doesn't match");
			}
			throw new UserNotFoundException("No user found with the credentials passed");
		}
      throw new LoginException("User is already logged in");		
	}

	@Override
	public List<Fir> getAllfirs() throws UserNotFoundException {
		// TODO Auto-generated method stub
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		String usnername = auth.getName();
		User u = userRepo.findByUsername(usnername);
		if(u != null)
		{
			return u.getFirsFiled();
		}
		
		throw new UserNotFoundException("User not found with the credentails passed");
	}

	@Override
	public Fir deleteFir(Long firId) throws UserNotFoundException, FirException {
		// TODO Auto-generated method stub
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		String usnername = auth.getName();
		User u = userRepo.findByUsername(usnername);
		if(u != null)
		{
		   
			Optional<Fir> of = firRepo.findById(firId);
			if(of.isPresent())
			{
				Fir f = of.get();
				 firRepo.delete(f);
				 return f;
			}
			throw new FirException("No fir found with the passed fir id");
		}
		
		throw new UserNotFoundException("User not found with the credentails passed");
	}

	
}
