package com.evuntu.management.exception;


public class LDAPValidationException extends Exception {

	/**
	 * 
	 */
	private  final String  errorMessage;
	private static final long serialVersionUID = -4102107161812912482L;

	public LDAPValidationException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
