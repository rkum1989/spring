package com.mc.demo.app.redeem.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;
	private String message;

	// constructor-1
	public ApplicationException(String message) {
		this.message = message;
	}

	// constructor-2
	public ApplicationException(HttpStatus httpStatusCode, String message) {
		this.message = message;
		this.statusCode = httpStatusCode;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

}
