////////////////////////////////////////////////////////////////////////////////////////////
// @ID: ApiControllerAdvice.java
// @Author: Rituraj Kumar
// Date: 9/20/2018.
//
// Purpose:
//
// CONFIDENTIAL -- Copyright 2018 Wipro.
// This is confidential and proprietary information of Wipro.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mc.demo.app.redeem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mc.demo.app.redeem.exception.ApplicationException;
import com.mc.demo.app.redeem.exception.BadRequestException;
import com.mc.demo.app.redeem.exception.ErrorInfo;
import com.mc.demo.app.redeem.exception.ErrorResponse;
import com.mc.demo.app.redeem.exception.ObjectNotFoundException;

@ControllerAdvice
@RestController
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> generalException(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("Fatal");
		error.setCode("serverUnavailable");
		error.setDetails("The request failed due to an internal error");
		error.setLocation("");
		error.setMoreinfo(e.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ApplicationException.class)
	public ResponseEntity<ErrorResponse> specialException(ApplicationException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("Fatal");
		error.setCode("serverUnavailable");
		error.setDetails("The request failed due to an internal error");
		error.setLocation("");
		error.setMoreinfo(e.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		errorResponse.setErrors(errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ErrorResponse> badRequestException(BadRequestException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("invalid");
		error.setCode("invalidRequest");
		error.setDetails("Missing or invalid Parameters");
		error.setLocation("");
		error.setMoreinfo(e.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		errorResponse.setErrors(errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ObjectNotFoundException.class)
	public ResponseEntity<ErrorResponse> objectNotFoundException(ObjectNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("Error");
		error.setCode("resourceNotFound");
		error.setDetails("Empty resource/resource not found");
		error.setLocation("");
		error.setMoreinfo(e.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		errorResponse.setErrors(errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("invalid");
		error.setCode("invalidRequest");
		error.setDetails("Missing or invalid Parameters");
		error.setLocation("");
		error.setMoreinfo(e.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		errorResponse.setErrors(errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ServletRequestBindingException.class)
	public ResponseEntity<ErrorResponse> servletRequestBindingException(ServletRequestBindingException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("invalid");
		error.setCode("invalidRequest");
		error.setDetails("Missing or invalid Parameters");
		error.setLocation("");
		error.setMoreinfo(e.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		errorResponse.setErrors(errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorResponse> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("invalid");
		error.setCode("invalidRequest");
		error.setDetails("Missing or invalid Parameters");
		error.setLocation("");
		error.setMoreinfo(e.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		errorResponse.setErrors(errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorInfo> errors = null;
		ErrorInfo error = new ErrorInfo();
		error.setType("Error");
		error.setCode("resourceNotFound");
		error.setDetails("Empty resource/resource not found");
		error.setLocation("");
		error.setMoreinfo(ex.getMessage());
		errors = new ArrayList<ErrorInfo>();
		errors.add(error);
		errorResponse.setErrors(errors);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
