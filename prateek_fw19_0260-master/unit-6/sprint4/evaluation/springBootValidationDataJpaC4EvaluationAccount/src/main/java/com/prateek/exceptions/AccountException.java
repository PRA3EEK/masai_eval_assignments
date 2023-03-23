package com.prateek.exceptions;

public class AccountException extends Exception{

	private String messsage;

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public AccountException(String messsage) {
		super();
		this.messsage = messsage;
	}
	
	
	
	
}
