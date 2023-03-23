package com.prateek.firApplication.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class Fir {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long firId;
	private String crimeDetail;
	private LocalDateTime timeStamp;
	private String policeStation;
	@ManyToOne@JsonIgnore
	private User user;
	@OneToMany(cascade = CascadeType.ALL)
	private List<User> FirAgainst = new ArrayList<>();
	
	
}
