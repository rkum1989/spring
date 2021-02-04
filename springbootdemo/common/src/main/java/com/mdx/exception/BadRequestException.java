////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: BadRequestException.java
//  @Author: Rituraj Kumar
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.exception;

import org.springframework.http.HttpStatus;

import static java.lang.String.format;

/**
 * Exception class for returning bad requests
 */
public class BadRequestException extends ServiceException {
    /**
     * Default serial verison UID
     */
    private static final long serialVersionUID = 1L;


    public BadRequestException(String msg) {
        super(ErrorCode.InvalidRequest, HttpStatus.BAD_REQUEST, format("Bad request encountered: %s%n", msg), "check request");
    }

}