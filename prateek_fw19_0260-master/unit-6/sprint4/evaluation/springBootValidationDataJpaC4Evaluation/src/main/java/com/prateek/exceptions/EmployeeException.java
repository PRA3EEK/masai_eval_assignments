package com.prateek.exceptions;

public class EmployeeException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmployeeException(String message) {
		super();
		this.message = message;
	}
	
	
	
	
}
