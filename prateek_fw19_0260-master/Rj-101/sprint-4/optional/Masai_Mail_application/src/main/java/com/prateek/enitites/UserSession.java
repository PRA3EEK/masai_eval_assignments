package com.prateek.enitites;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class UserSession {
  
	@Id
	private String emailId;
	private String username;
	private String password;
	private LocalDateTime timeStamp;
	
}
