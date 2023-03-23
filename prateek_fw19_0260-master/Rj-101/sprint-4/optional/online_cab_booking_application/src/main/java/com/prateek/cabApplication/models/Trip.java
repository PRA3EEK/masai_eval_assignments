package com.prateek.cabApplication.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tripId;
	@ManyToOne
	private Driver driver;
	private double distance;
	private double bill;
	@ManyToOne@JsonIgnore
	private User user;
	private Integer[] sourceCordinates;
	private Integer[] destinationCordinates;
	private LocalDateTime bookingDateAndTime;
	private LocalDateTime tripEndDateAndTime;
	
}
