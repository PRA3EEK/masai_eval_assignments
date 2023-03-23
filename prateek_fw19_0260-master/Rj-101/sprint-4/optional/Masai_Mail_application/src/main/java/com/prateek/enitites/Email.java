package com.prateek.enitites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long generatedEmailId;
	private String sendTo;
	private String title;
	private String body;
	public String starred;
	@ManyToOne(cascade = CascadeType.ALL)@JsonIgnore
	private User user;
	
}
