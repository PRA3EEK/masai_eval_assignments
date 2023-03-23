package com.prateek.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserSession {

	private LocalDateTime timeStamp;
	@Id
	private Long id;
	private String username;
	private String password;
	
}
