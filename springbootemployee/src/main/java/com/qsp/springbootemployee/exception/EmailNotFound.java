package com.qsp.springbootemployee.exception;

public class EmailNotFound extends RuntimeException
{
	String message;
	
	@Override
	public String getMessage() 
	{
		return message;
	}

	public EmailNotFound(String message) 
	{
		super();
		this.message = message;
	}
}
