package com.jsp.CloneAPIBookMyShow.exception;

public class TheatreAlreadyPresentInThisLocationException  extends RuntimeException{

	private String message;

	public TheatreAlreadyPresentInThisLocationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
