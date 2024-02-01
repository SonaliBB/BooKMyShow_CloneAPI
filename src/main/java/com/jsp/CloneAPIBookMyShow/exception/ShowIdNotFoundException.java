package com.jsp.CloneAPIBookMyShow.exception;

public class ShowIdNotFoundException extends RuntimeException {

	private String message;

	public ShowIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
