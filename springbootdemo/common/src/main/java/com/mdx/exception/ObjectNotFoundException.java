////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: ObjectNotFoundException.java
//  @Author: Rituraj Kumar
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.exception;

import org.springframework.http.HttpStatus;

import static java.lang.String.format;

/**
 * Exception class for returning bad requests
 * 
 */
public class ObjectNotFoundException extends ServiceException
{
    /**
     * Default serial verison UID
     */
    private static final long serialVersionUID = 1L;
    
    
	public ObjectNotFoundException(String msg) 
	{
        super(ErrorCode.ObjectNotFound, HttpStatus.NOT_FOUND, format("Specified object not found: %s%n", msg), "check request");
    }
	
}