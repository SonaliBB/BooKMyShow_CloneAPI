package com.jsp.CloneAPIBookMyShow.exception;

public class TicketAlreadyExpiredException extends RuntimeException {

	private String message;

	public TicketAlreadyExpiredException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
