////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: ObjectNotFoundException.java
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
public class ObjectNotFoundException extends DealerServiceException 
{
    /**
     * Default serial verison UID
     */
    private static final long serialVersionUID = 1L;
    
    
	public ObjectNotFoundException(String msg) 
	{
        super(ErrorCode.ObjectNotFound, HttpStatus.NOT_FOUND, format("Specified object not found: %s\n", msg), "check request");
    }
	
}