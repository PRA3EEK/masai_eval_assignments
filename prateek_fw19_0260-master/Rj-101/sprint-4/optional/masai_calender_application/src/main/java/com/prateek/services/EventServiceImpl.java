package com.prateek.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.prateek.exceptions.EventNotFoundException;
import com.prateek.exceptions.InvalidDateException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.models.Event;

import com.prateek.models.User;
import com.prateek.repos.EventRepo;
import com.prateek.repos.UserRepo;

public class EventServiceImpl implements EventService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EventRepo eventRepo;
	
	@Override
	public Event addEvent(Event event, String userId) throws UserNotFoundException, InvalidDateException {
		// TODO Auto-generated method stub
		
		Optional<User> ou = userRepo.findById(userId);
		
		if(ou.isPresent())
		{
			if(event.getStartTime().isBefore(LocalDateTime.now()))
			{
				throw new InvalidDateException("Starting date of the even should not be in past");
			}
			if(event.getStartTime().isAfter(event.getEndTime()))
			{
				throw new InvalidDateException("Event starting date must be in the past in relative to event end date");
			}
			User u = ou.get();
			u.getEvents().add(event);
			event.setUser(u);
			userRepo.save(u);
			return eventRepo.save(event);
		}
		
		throw new UserNotFoundException("User not found");
	}

	@Override
	public Event updateEvent(Event event, Long eventId) throws EventNotFoundException {
		// TODO Auto-generated method stub
		Optional<Event> oe = eventRepo.findById(eventId);
		if(oe.isPresent())
		{
			return eventRepo.save(event);
		}
		throw new EventNotFoundException("No event found with the id "+eventId);
	}

}
