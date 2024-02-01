package com.jsp.CloneAPIBookMyShow.exception;

public class ShowIsNotActiveException extends RuntimeException {

	private String message;

	public ShowIsNotActiveException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
