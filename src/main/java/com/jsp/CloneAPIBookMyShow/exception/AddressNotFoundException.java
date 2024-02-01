package com.jsp.CloneAPIBookMyShow.exception;

public class AddressNotFoundException extends RuntimeException {
	private String message;

	public AddressNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
