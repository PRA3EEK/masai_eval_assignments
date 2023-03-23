package com.prateek.test;

public class EmployeeException extends Exception{

	private String message;

	public EmployeeException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
