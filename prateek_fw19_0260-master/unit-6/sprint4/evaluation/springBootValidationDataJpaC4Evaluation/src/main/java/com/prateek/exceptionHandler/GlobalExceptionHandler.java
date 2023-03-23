package com.prateek.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.prateek.exceptions.EmployeeException;
import com.prateek.exceptions.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorDetails> EmployeeExceptionHandler(EmployeeException ee, WebRequest wr){
		
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ee.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
