package com.prateek.cabApplication.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.cabApplication.models.Trip;


public interface TripRepo extends JpaRepository<Trip, Long>{

}
