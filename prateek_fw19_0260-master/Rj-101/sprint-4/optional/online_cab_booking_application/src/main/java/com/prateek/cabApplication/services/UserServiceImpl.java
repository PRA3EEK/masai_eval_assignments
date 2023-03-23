package com.prateek.cabApplication.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prateek.cabApplication.DTO.UserDTO;
import com.prateek.cabApplication.exceptions.DriverNotFoundException;
import com.prateek.cabApplication.exceptions.DuplicateUsernameException;
import com.prateek.cabApplication.exceptions.PasswordMismatchException;
import com.prateek.cabApplication.exceptions.UserNotFoundException;
import com.prateek.cabApplication.models.Driver;
import com.prateek.cabApplication.models.Trip;
import com.prateek.cabApplication.models.User;
import com.prateek.cabApplication.models.UserCurrentSession;
import com.prateek.cabApplication.repos.DriverRepo;
import com.prateek.cabApplication.repos.TripRepo;
import com.prateek.cabApplication.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private DriverRepo driverRepo;
	@Autowired
	private TripRepo tripRepo;
	
	@Override
	public User registerUser(User user) throws DuplicateUsernameException {
		// TODO Auto-generated method stub
		
		User u = userRepo.findByUsername(user.getUsername());
		
		if(u == null)
		{
			
		return userRepo.save(user);
			
		}
		
    throw new DuplicateUsernameException("Username not available");
	}

	@Override
	public UserCurrentSession loginUser(UserDTO userDetails) throws UserNotFoundException, PasswordMismatchException {
		// TODO Auto-generated method stub
	  
		User u = userRepo.findByUsername(userDetails.getUsername());
		
		if(u!=null)
		{
			if(u.getPassword().equals(userDetails.getPassword()))
			{
				UserCurrentSession currentSession = new UserCurrentSession(u.getId(), u.getUsername(), u.getPassword(), UUID.randomUUID().toString() , LocalDateTime.now());
				   return currentSession;
			}
			throw new PasswordMismatchException("Password does not match");
		}
		throw new UserNotFoundException("No user found with these user details");
	}

	@Override
	public List<Driver> findRides(Long userid) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		List<Driver> res = new ArrayList<>();
		
		Optional<User> ou = userRepo.findById(userid);
		
		if(!ou.isPresent()) throw new UserNotFoundException("No user was found with the id you passed");
		
		User u = ou.get();
		List<Driver> drivers = driverRepo.findAll();
		for(Driver d:drivers)
		{
			int x2 = d.getAddress().getPositionCordinates()[0];
			int y2 = d.getAddress().getPositionCordinates()[1];
			int x1 = u.getAddress().getPositionCordinates()[0];
			int y1 = u.getAddress().getPositionCordinates()[1];
			
			if(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) <= 5)
				 res.add(d);
		}
		
		return res;
	}

	@Override
	public Trip bookRide(Long driverId, Integer x_cordinate, Integer y_cordinate, Trip trip, Long userId) throws UserNotFoundException, DriverNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Driver> od = driverRepo.findById(driverId);
		
		if(od.isPresent())
		{
			
			Optional<User> ou = userRepo.findById(userId);
			
			if(ou.isPresent())
			{
			 User u = ou.get();	
			 int x2 = x_cordinate;
			 int y2 = y_cordinate;
			 int x1 = u.getAddress().getPositionCordinates()[0];
			 int y1 = u.getAddress().getPositionCordinates()[1];
			 double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
			 double bill = 0;
			 Driver d = od.get();
			 trip.setDriver(d);
			 trip.setDistance(distance);
			 if(distance > 2)
			 {
				  bill = (distance-2)*8 + 40;
			 }else
			 {
				  bill = 40;
			 }
			 trip.setBill(bill);
			 trip.setDriver(d);
			 trip.setSourceCordinates(u.getAddress().getPositionCordinates());
			 trip.setDestinationCordinates(new Integer[]{x_cordinate, y_cordinate});
			 trip.setBookingDateAndTime(LocalDateTime.now());
			 trip.setTripEndDateAndTime(LocalDateTime.now());
			 
			 d.getTrips().add(trip);
			 u.getTrips().add(trip);
			 tripRepo.save(trip);
			}
			
			throw new UserNotFoundException("No user found with the id you passed");
			
		}
		
		throw new DriverNotFoundException("No driver found with the driver id you passed");
		
	}

}
