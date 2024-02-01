package com.jsp.CloneAPIBookMyShow.exception;

public class SeatIdNotFoundException extends RuntimeException {

	private String message;

	public SeatIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
