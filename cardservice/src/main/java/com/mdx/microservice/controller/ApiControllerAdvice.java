package com.mdx.microservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mdx.microservice.exceptions.BadRequestException;
import com.mdx.microservice.exceptions.DealerServiceException;
import com.mdx.microservice.exceptions.ErrorInfo;
import com.mdx.microservice.exceptions.ErrorType;
import com.mdx.microservice.exceptions.ObjectNotFoundException;


@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

    /**
     * Request header invalid bff.exceptions means that a header that was required by a downstream service was not present in request context
     * @param e is the exception details for this error
     * @return  a response entity with {@link ErrorInfo} details
     */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
    ResponseEntity<ErrorInfo> badRequestException(BadRequestException e) {
        return error(createErrorInfo(e.getMessage(), e.getStatusCode(), ErrorType.USER_ERROR), e.getStatusCode());
    }

    /**
     * Request header invalid bff.exceptions means that a header that was required by a downstream service was not present in request context
     * @param e is the exception details for this error
     * @return  a response entity with {@link ErrorInfo} details
     */
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    ResponseEntity<ErrorInfo> objectNotFoundException(ObjectNotFoundException e) {
        return error(createErrorInfo(e.getMessage(), e.getStatusCode(), ErrorType.USER_ERROR), HttpStatus.NOT_FOUND);
    }

    /**
     * Service bff.orchestration bff.exceptions mean that a downstream service returned a bad http status code
     * @param e is the exception details for this error
     * @return a response entity with {@link ErrorInfo} details
     */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DealerServiceException.class)
    ResponseEntity<ErrorInfo> dealerServiceException(DealerServiceException e) {
        return error(createErrorInfo(e.getMessage(), e.getStatusCode(), ErrorType.SYSTEM_ERROR), e.getStatusCode());
    }

    /**
     * Generic error implying a bad request from a service consumer
     * @param e is the exception details for this error
     * @return a response entity with {@link ErrorInfo} details
     */
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorInfo> exception(Exception e) {
        return error(createErrorInfo(e.getMessage(), Integer.valueOf(HttpStatus.BAD_REQUEST.value()).toString(), 
        		ErrorType.APP_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Report the error as the HTTP response of the type {@link ErrorInfo}
     * @param e is the exception details for this error
     * @param httpStatus is the HTTP Status for the bad request
     * @param <E> is the generic time for the response entity
     * @return a response entity with {@link ErrorInfo} details
     */
    private <E extends ErrorInfo> ResponseEntity<E> error(E e, HttpStatus httpStatus) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(e, httpHeaders, httpStatus);
    }
    
    /**
     * Produce a meaningful error message when issues are abound
     *
     * @param errorMessage is the informative error message for this problematic operation
     * @param errorCode    is the HTTP status code for the error
     * @param errorType    is the type of error for the request
     * @return a {@link com.intuit.schema.fs.common.v2.ErrorInfo} object containing useful information about this error
     */
    private static ErrorInfo createErrorInfo(String errorMessage, HttpStatus errorCode, ErrorType errorType) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(Integer.valueOf(errorCode.value()).toString());
        // errorInfo.setErrorMessage(errorCode.getReasonPhrase() + ": " + errorMessage);
        errorInfo.setErrorMessage(errorMessage);
        errorInfo.setErrorType(errorType);
        return errorInfo;
    }

    /**
     * Produce a meaningful error message when issues are abound
     *
     * @param errorMessage is the informative error message for this problematic operation
     * @param errorCode    is an application specific error code to correlate to the problem
     * @param errorType    is the type of error for the request
     * @return a {@link ErrorInfo} object containing useful information about this error
     */
    private static ErrorInfo createErrorInfo(String errorMessage, String errorCode, ErrorType errorType) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(errorCode);
        errorInfo.setErrorMessage(errorMessage);
        errorInfo.setErrorType(errorType);
        return errorInfo;
    }
}
