package com.jsp.CloneAPIBookMyShow.exception;

public class TheatreIdNotFoundException extends RuntimeException{

	private String message;

	public TheatreIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
