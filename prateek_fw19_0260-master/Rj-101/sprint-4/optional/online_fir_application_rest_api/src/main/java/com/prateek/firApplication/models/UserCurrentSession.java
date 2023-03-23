package com.prateek.firApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class UserCurrentSession {

	@Id
	private Long userId;
	private String username;
	private String password;
	private String loginKey;
	
}
