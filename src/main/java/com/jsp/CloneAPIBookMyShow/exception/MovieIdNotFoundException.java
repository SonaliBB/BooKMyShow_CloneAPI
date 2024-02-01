package com.jsp.CloneAPIBookMyShow.exception;

public class MovieIdNotFoundException extends RuntimeException {
	private String message;

	public MovieIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
