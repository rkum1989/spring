////////////////////////////////////////////////////////////////////////////////////////
//
//	@Id: ErrorCode.java
//  @Author: Shekhar Cambam
//
//////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.microservice.exceptions;


public enum ErrorCode {
	
	ServiceError(600000, "service_error"),
	MissingField(600001, "missing_field"),
	InvalidField(600002, "invalid_field"),
	InvalidRequest(600003, "InvalidRequest"),
	InvalidFieldType(600004, "invalid_field_type"),
	ObjectNotFound(600008, "object not_found"),
	InvalidJson(600010, "invalid_json");
	
	// data-members.
	private final Integer errorCode;
	private final String type;
	
	// private-constructor.
	private ErrorCode(final Integer errorCode, final String type) {
		this.errorCode = errorCode;
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Integer getCode() {
		return this.errorCode;
	}
	
}
