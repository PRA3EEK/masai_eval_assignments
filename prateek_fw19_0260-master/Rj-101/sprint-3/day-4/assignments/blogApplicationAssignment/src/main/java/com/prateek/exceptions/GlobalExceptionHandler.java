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

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> validationExceptionHandler(MethodArgumentNotValidException manve)
	{
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), manve.getMessage(), manve.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ue, WebRequest we)
	{
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ue.getMessage(), we.getDescription(false));
	return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public ResponseEntity<ErrorDetails> postNotFoundExceptionHandler(PostNotFoundException pnfe, WebRequest we)
	{
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), pnfe.getMessage(), we.getDescription(false));
	return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CommentNotFoundException.class)
	public ResponseEntity<ErrorDetails> commentNotFoundExceptionHandler(CommentNotFoundException ue, WebRequest we)
	{
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ue.getMessage(), we.getDescription(false));
	return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateUsernameException.class)
	public ResponseEntity<ErrorDetails> duplicateUsernameExceptionHandler(DuplicateUsernameException ue, WebRequest we)
	{
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), ue.getMessage(), we.getDescription(false));
	return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
}
