package com.prateek.cabApplication.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NegativeOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
@Table(name = "driver")
public class Driver extends AbstractUser{
   
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long driverId;
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
	private List<Trip> trips = new ArrayList<>();
	
	
}
