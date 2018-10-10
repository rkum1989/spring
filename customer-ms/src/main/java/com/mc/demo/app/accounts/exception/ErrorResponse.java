package com.mc.demo.app.accounts.exception;

import java.util.List;

public class ErrorResponse {

	private List<ErrorInfo> error;

	public void setErrors(List<ErrorInfo> error) {
		this.error = error;
	}

	public List<ErrorInfo> getError() {
		return error;
	}

}
