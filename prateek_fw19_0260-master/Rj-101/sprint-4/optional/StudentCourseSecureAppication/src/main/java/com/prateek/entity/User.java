package com.prateek.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data@AllArgsConstructor@NoArgsConstructor
public class User {
	private String username;
	private String password;
	private String address;
	private String role;
	private String email;
	private String phoneNumber;
}
