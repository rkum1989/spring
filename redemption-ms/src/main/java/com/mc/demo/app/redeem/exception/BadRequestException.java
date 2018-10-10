package com.mc.demo.app.redeem.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(HttpStatus.BAD_REQUEST, msg);
	}

}
