package com.pets.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(NoSuchIdFoundException ex){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateIdFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(DuplicateIdFoundException ex){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchDataFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(NoSuchDataFoundException ex){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoAvailableServicesFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(NoAvailableServicesFoundException ex){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoUnavailableServicesFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(NoUnavailableServicesFoundException ex){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuccessfulTransactionsFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(NoSuccessfulTransactionsFoundException ex){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoFailedTransactionsFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(NoFailedTransactionsFoundException ex){
		
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.toString());
		err.setTimestamp(LocalDate.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
}
