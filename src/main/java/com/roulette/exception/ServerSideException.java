package com.roulette.exception;

public class ServerSideException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The Server side exception
	 * @param message
	 */
    public ServerSideException(String message) {
    	super(message);
    }
}
