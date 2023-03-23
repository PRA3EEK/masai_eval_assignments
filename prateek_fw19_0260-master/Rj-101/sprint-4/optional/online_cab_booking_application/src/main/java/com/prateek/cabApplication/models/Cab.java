package com.prateek.cabApplication.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@AllArgsConstructor@Data@NoArgsConstructor
public class Cab {
  
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cabId;
	private String cabName;
	private String cabType;
	private String cabNumber;
	@OneToOne@JsonIgnore
	private Driver driver;
	
}
