package com.mc.demo.app.redeem.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends ApplicationException {
	private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(HttpStatus.NOT_FOUND, msg);
    }
}
