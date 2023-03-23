package com.prateek.exceptions;

public class InsufficientFundException extends Exception{ 

	
	private String messsage;

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public InsufficientFundException(String messsage) {
		super();
		this.messsage = messsage;
	}
	
}
