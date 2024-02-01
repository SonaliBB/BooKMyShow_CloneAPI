package com.jsp.CloneAPIBookMyShow.exception;

public class ProductionHouseNotFoundException extends RuntimeException {

	private String message;

	public ProductionHouseNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}}
