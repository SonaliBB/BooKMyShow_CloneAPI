package com.jsp.CloneAPIBookMyShow.exception;

public class TicketAlreadyCancelledException extends RuntimeException {
	private String message;

	public TicketAlreadyCancelledException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
