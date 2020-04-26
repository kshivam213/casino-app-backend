package com.roulette.exception;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	

	 /**
 	 * Instantiates a new resource not found exception.
 	 *
 	 * @param resourceId the resource id
 	 * @param message the message
 	 */
 	public ResourceNotFoundException(final Long resourceId, final String message) {
	        super(message);
	 }
}
