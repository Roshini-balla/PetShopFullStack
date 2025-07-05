package com.pets.exceptions;

public class NoSuchIdFoundException extends RuntimeException {
	
	public NoSuchIdFoundException(String message)
	{
		super(message);
	}

}
