package com.jsp.CloneAPIBookMyShow.exception;

public class TicketCannotBeCancelledException extends RuntimeException {

	private String message;

	public TicketCannotBeCancelledException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
