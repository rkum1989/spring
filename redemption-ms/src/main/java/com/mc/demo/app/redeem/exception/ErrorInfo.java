package com.mc.demo.app.redeem.exception;

public class ErrorInfo {
	private String type;
	private String code;
	private String details;
	private String location;
	private String moreinfo;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setMoreinfo(String moreinfo) {
		this.moreinfo = moreinfo;
	}

	public String getMoreinfo() {
		return moreinfo;
	}
}
