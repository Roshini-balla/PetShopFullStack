package com.pets.exceptions;

public class DuplicateIdFoundException extends RuntimeException {
	
	public DuplicateIdFoundException(String message)
	{
		super(message);
	}

}
