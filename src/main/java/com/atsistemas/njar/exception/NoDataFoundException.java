package com.atsistemas.njar.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

public class NoDataFoundException extends NotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {
		super();
	}

	public NoDataFoundException(Response response, Throwable cause) {
		super(response, cause);
	}

	public NoDataFoundException(Response response) {
		super(response);
	}

	public NoDataFoundException(String message, Response response, Throwable cause) {
		super(message, response, cause);
	}

	public NoDataFoundException(String message, Response response) {
		super(message, response);
	}

	public NoDataFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoDataFoundException(String message) {
		super(message);
	}

	public NoDataFoundException(Throwable cause) {
		super(cause);
	}	
}
