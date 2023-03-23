package com.prateek.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException manve, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(manve, manve.getMessage(), manve.getBindingResult().getFieldError().getDefaultMessage(), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(DuplicateUsernameException.class)
	public ResponseEntity<ErrorDetails> duplicateUserameExceptionHandler(DuplicateUsernameException due, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(due, due.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(InvalidDateException.class)
	public ResponseEntity<ErrorDetails> invalidDateExceptionHandler(InvalidDateException ide, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(ide, ide.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<ErrorDetails> passwordMismatchExceptionHandler(PasswordMismatchException pme, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(pme, pme.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler(UserNotFoundException unfe, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(unfe, unfe.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorDetails> validationExceptionHandler(ValidationException ve, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(ve, ve.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ErrorDetails> usernameNotFoundExceptionHandler(UsernameNotFoundException unfe, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(unfe, unfe.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	
	@ExceptionHandler(InvalidTypeException.class)
	public ResponseEntity<ErrorDetails> invalidTypeExceptionHandler(InvalidTypeException ite, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(ite, ite.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(EventNotFoundException.class)
	public ResponseEntity<ErrorDetails> eventNotFoundExceptionHandler(EventNotFoundException enfe, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(enfe, enfe.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
}
