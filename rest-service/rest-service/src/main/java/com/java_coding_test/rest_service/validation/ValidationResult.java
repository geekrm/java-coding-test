package com.java_coding_test.rest_service.validation;

public class ValidationResult {

	private boolean isSuccess;
	private String message;
	
	public static final ValidationResult OK = new ValidationResult(true);
	
	public ValidationResult(boolean isSuccess) {
		this(isSuccess, "");
	}
	
	public ValidationResult(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}
	
	public void setSuccess(boolean success) {
		this.isSuccess = success;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
