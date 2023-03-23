package com.prateek.firApplication.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
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
		ErrorDetails er = new ErrorDetails(manve.getClass().getName(), manve.getMessage(), manve.getBindingResult().getFieldError().getDefaultMessage(), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException le, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(le.getClass().getName(), le.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(DuplicateUsernameException.class)
	public ResponseEntity<ErrorDetails> duplicateUserameExceptionHandler(DuplicateUsernameException due, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(due.getClass().getName(), due.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	
	@ExceptionHandler(IncorrectPasswordException.class)
	public ResponseEntity<ErrorDetails> incorrectPasswordExceptionHandler(IncorrectPasswordException ipe, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(ipe.getClass().getName(), ipe.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler(UserNotFoundException unfe, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(unfe.getClass().getName(), unfe.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorDetails> validationExceptionHandler(ValidationException ve, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(ve.getClass().getName(), ve.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ErrorDetails> usernameNotFoundExceptionHandler(UsernameNotFoundException unfe, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(unfe.getClass().getName(), unfe.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(FirException.class)
	public ResponseEntity<ErrorDetails> firExceptionHandler(FirException fe, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(fe.getClass().getName(), fe.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> sqlIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException sqlicve, WebRequest wr)
	{
		ErrorDetails er = new ErrorDetails(sqlicve.getClass().getName(), sqlicve.getMessage(), wr.getDescription(false), LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);	
	}
	
}
