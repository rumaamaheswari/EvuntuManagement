/**
 * 
 */
package com.evuntu.management.exception;

/**
 * @author uma maheswari
 *
 */
public class EvuntuManagementException extends Exception {

	private  final String  errorMessage;
	private static final long serialVersionUID = -4102107161812912482L;

	public EvuntuManagementException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
