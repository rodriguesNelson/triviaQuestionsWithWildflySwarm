package com.atsistemas.njar.exception;

public class ResourceNotFoundException extends ManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
}
