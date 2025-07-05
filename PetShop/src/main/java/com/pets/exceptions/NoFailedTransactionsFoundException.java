package com.pets.exceptions;

public class NoFailedTransactionsFoundException extends RuntimeException {

	public NoFailedTransactionsFoundException(String message)
	{
		super(message);
	}
	
}
