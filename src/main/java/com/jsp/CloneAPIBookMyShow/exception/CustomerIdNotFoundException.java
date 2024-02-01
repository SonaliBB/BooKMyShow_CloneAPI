package com.jsp.CloneAPIBookMyShow.exception;

public class CustomerIdNotFoundException extends RuntimeException {

	private String message;

	public CustomerIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
