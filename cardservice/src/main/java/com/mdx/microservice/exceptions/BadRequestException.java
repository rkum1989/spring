////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: BadRequestException.java
//  @Author: Shekhar Cambam
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.exceptions;

import static java.lang.String.format;

import org.springframework.http.HttpStatus;

/**
 * Exception class for returning bad requests
 * 
 */
public class BadRequestException extends DealerServiceException 
{
    /**
     * Default serial verison UID
     */
    private static final long serialVersionUID = 1L;
    
    
	public BadRequestException(String msg) 
	{
        super(ErrorCode.InvalidRequest, HttpStatus.BAD_REQUEST, format("Bad request encountered: %s\n", msg), "check request");
    }
	
}