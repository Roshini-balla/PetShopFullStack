package com.pets.exceptions;

import java.time.LocalDate;
import java.util.Date;

public class ErrorResponse {
	
	private String message;
	private String status;
	private LocalDate timestamp;
	
	public ErrorResponse(String message, String status, LocalDate timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

	public ErrorResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	
}
