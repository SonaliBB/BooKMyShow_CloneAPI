package com.jsp.CloneAPIBookMyShow.exception;

public class ScreenIdNotFoundException extends RuntimeException {
	private String message;

	public ScreenIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
