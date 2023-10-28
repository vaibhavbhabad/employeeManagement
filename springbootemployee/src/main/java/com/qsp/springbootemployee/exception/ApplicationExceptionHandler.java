package com.qsp.springbootemployee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.springbootemployee.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.message);
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Employee with given Id not found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataNotFound.class)
	public ResponseEntity<ResponseStructure<String>> dataNotFoundExceptionHandler(DataNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.message);
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Table doesn't contains any data");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundExceptionHandler(EmailNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.message);
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Employee with the given email is not found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponseStructure<String>> phoneNotFoundExceptionHandler(PhoneNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.message);
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Employee with the given phone is not found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoDataAvailable.class)
	public ResponseEntity<ResponseStructure<String>> noDataAvailableExceptionHandler(NoDataAvailable ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage(ex.message);
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Data within given range is not available");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
}
