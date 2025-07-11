package com.pets.exceptions;

public class NoSuccessfulTransactionsFoundException extends RuntimeException {

	public NoSuccessfulTransactionsFoundException(String message)
	{
		super(message);
	}
	
}
