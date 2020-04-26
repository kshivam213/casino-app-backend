package com.roulette.exception;

public class UnauthorizedException extends RuntimeException{
	
	 /** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		 /**
	 	 * Instantiates a new bad request exception.
	 	 *
	 	 * @param message the message
	 	 */
	 	public UnauthorizedException(String message) {
		        super(message);
		 }

}
