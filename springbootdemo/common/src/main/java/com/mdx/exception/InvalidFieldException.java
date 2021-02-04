/////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: InvalidFieldException.java
//  @Author: Shekhar Cambam
//
//	CONFIDENTIAL -- Copyright 2015 Digital Insight. 
//	This is confidential and proprietary information of Digital Insight.
//	Use, reproduction, disclosure and distribution by any means are prohibited,except 
//	pursuant to a written license from Digital Insight. 
//	Use of copyright notice is precautionary and does not imply publication or disclosure.
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.exception;

import org.springframework.http.HttpStatus;

public class InvalidFieldException extends ServiceException 
{	
	private static final long serialVersionUID = 1L;

	public InvalidFieldException(String fieldName, Object value) 
	{
		//super(fieldName + " = " + value);
		super(ErrorCode.InvalidField, HttpStatus.BAD_REQUEST, "Invalid value for " + fieldName + ": " + ( value != null ? value.toString() : "null"), "You've specified an invalid value for the field " + fieldName);
	}
	
	public InvalidFieldException(String fieldName, String devMessage, Object value) 
	{
		//super(fieldName + " = " + value);
		super(ErrorCode.InvalidField, HttpStatus.BAD_REQUEST, "Invalid value for " + fieldName + ": " + ( value != null ? value.toString() : "null"), "You've specified an invalid value for the field " + fieldName + "," +devMessage);
	} 
	
	public InvalidFieldException(String fieldName)
	{
		//super(fieldName + " = is in error.");
		super(ErrorCode.InvalidField, HttpStatus.BAD_REQUEST, "Invalid value for " + fieldName, "You've specified an invalid value for the field " + fieldName);
	}
	
}
