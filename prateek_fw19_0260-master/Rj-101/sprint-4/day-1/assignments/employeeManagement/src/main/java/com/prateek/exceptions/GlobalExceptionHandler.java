package com.prateek.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorDetails> employeeExceptionHandler(EmployeeException ee, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ee.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> adminExceptionHandler(AdminException ee, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ee.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DuplicateUsernameException.class)
	public ResponseEntity<ErrorDetails> duplicateUsernameExceptionHandler(DuplicateUsernameException ee, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ee.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ReportingManagerException.class)
	public ResponseEntity<ErrorDetails> reportingManagerExceptionHandler(ReportingManagerException ee, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ee.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> employeeExceptionHandler(MethodArgumentNotValidException ee, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ee.getMessage(),ee.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
}
