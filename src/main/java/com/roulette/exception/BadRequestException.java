package com.roulette.exception;
/**
 * The Class BadRequestException.
 */
public class BadRequestException extends RuntimeException{
	
	 /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	 /**
 	 * Instantiates a new bad request exception.
 	 *
 	 * @param message the message
 	 */
 	public BadRequestException(String message) {
	        super(message);
	 }
}
