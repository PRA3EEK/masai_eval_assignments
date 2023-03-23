package com.prateek.cabApplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class PasswordMismatchException extends Exception{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

}
