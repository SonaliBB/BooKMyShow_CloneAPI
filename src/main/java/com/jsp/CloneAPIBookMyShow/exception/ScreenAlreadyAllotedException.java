package com.jsp.CloneAPIBookMyShow.exception;

public class ScreenAlreadyAllotedException extends RuntimeException{
	private String message;

	public  ScreenAlreadyAllotedException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
