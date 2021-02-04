////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: ServiceException.java
//  @Author: Rituraj Kumar
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.exception;

import org.springframework.http.HttpStatus;


public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // [ data-members ]
    protected HttpStatus statusCode;
    protected ErrorCode errorCode;
    protected String developerMessage;

    // constructor-1
    public ServiceException(ErrorCode errorCode, String message, String developerMessage) {
        super(message);
        this.errorCode = errorCode;
        this.developerMessage = developerMessage;
    }

    // constructor-2
    public ServiceException(ErrorCode errorCode, HttpStatus httpStatusCode, String message, String developerMessage) {
        this(errorCode, message, developerMessage);
        this.statusCode = httpStatusCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

}