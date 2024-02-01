package com.jsp.CloneAPIBookMyShow.exception;

public class TheatreAlreadyPresentInThisAddressException extends RuntimeException {
	private String message;

	public TheatreAlreadyPresentInThisAddressException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
