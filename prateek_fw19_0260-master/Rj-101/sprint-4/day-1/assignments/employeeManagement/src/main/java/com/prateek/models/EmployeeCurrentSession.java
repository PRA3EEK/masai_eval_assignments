package com.prateek.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class EmployeeCurrentSession {

	@Id
	private Long id;
	private LocalDateTime timeStamp;
	private String loggedInKey;
}
