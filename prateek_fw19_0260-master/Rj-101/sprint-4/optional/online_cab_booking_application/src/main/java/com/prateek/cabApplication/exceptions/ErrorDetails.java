package com.prateek.cabApplication.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class ErrorDetails {

	private Exception exception;
	private String message;
	private String desc;
	private LocalDateTime timeStamp;
	
}
