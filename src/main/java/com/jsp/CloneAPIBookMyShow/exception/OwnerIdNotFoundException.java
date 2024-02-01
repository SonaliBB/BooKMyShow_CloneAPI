package com.jsp.CloneAPIBookMyShow.exception;

public class OwnerIdNotFoundException extends RuntimeException {

	private String message;

	public OwnerIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
}
