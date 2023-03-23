package com.prateek.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class Event {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eventId;
	@NotNull
	@NotBlank
	private String eventName;
	@NotNull
	@NotBlank
	private String location;
	@NotNull
	@NotBlank
	private LocalDateTime startTime;
	@NotNull
	@NotBlank
	private LocalDateTime endTime;
	@NotNull
	@NotBlank
	private String eventDescription;
	@NotNull
	@NotBlank
	private String recurring;
	@ManyToOne(cascade = CascadeType.ALL)@JsonIgnore
	private User user;
	
	
	
}
