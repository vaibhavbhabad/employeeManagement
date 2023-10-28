package com.qsp.springbootemployee.exception;

public class PhoneNotFound extends RuntimeException {

	String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public PhoneNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
