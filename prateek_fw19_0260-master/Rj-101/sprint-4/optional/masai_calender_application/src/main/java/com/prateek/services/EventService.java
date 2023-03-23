package com.prateek.services;

import com.prateek.exceptions.EventNotFoundException;
import com.prateek.exceptions.InvalidDateException;
import com.prateek.exceptions.UserNotFoundException;
import com.prateek.models.Event;

public interface EventService {

	public Event addEvent(Event event, String userId) throws UserNotFoundException, InvalidDateException;
	
	public Event updateEvent(Event event, Long eventId) throws EventNotFoundException;
	
}
