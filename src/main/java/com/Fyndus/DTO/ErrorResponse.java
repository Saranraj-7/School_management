package com.Fyndus.DTO;

public class ErrorResponse {

	private String message;

	private int statuscode;

	public ErrorResponse(String message, int statuscode) {
		this.setMessage(message);
		this.setStatuscode(statuscode);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
}
