package com.prateek.cabApplication.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class User extends AbstractUser{

	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Trip> trips = new ArrayList<>();
	
	
	
}
