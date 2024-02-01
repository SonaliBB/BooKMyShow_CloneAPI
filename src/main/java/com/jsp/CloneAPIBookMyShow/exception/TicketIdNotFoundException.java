package com.jsp.CloneAPIBookMyShow.exception;

public class TicketIdNotFoundException extends RuntimeException{

	private String message;

	public TicketIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
