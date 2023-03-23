package com.prateek.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime creationDate;
	@NotNull(message = "Comment cannot be null")
	@NotBlank(message = "Comment cannot be blank")
	private String message;
	private String userName;
	@ManyToOne@JsonIgnore
	private Post post;
	@ManyToOne@JsonIgnore
	private User user;
	
	
	
	
}
