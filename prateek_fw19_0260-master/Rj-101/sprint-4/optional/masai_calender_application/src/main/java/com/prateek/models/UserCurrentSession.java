package com.prateek.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class UserCurrentSession {

	@Id
	private String id;
	@NotNull
	@NotBlank
	private String usid;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;

	private LocalDateTime loginTimeStamp;
	
}
