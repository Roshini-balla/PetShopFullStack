package com.pets.enums;

public enum transaction_status {

	Failed,
	Success;
	
	public String getStatus()
	{
	   return this.name();	
	}
}
