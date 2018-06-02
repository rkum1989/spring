////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: ErrorInfo.java
//  @Author: Shekhar Cambam
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.exceptions;


public class ErrorInfo {

	private String errorCode;
	private String errorMessage;
	private ErrorType errorType;
	
	public ErrorType getErrorType() {
		return errorType;
	}
	
	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		
	}
	
}