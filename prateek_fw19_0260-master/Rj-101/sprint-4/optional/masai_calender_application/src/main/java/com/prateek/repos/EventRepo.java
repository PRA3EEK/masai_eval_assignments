package com.prateek.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.models.Event;

public interface EventRepo extends JpaRepository<Event, Long>{

}
