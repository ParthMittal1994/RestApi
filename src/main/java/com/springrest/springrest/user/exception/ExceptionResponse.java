package com.springrest.springrest.user.exception;

import java.util.Date;

public class ExceptionResponse {
	public ExceptionResponse(String message, Date timestamp, String detail) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.detail = detail;
	}
	public String message;  
	public Date timestamp;
	public String detail ;
	public String getMessage() {
		return message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getDetail() {
		return detail;
	}
	/*
	 * public void setMessage(String message) { this.message = message; } public
	 * void setTimestamp(Date timestamp) { this.timestamp = timestamp; } public void
	 * setDetail(String detail) { this.detail = detail; }
	 */

}
