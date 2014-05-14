package com.pariyani.exception;


/**
 * 
 * @author imran
 */
public class PositionOutOfBoundException extends Exception {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -1652996927909590834L;

	public PositionOutOfBoundException() {
		super();
	}

	public PositionOutOfBoundException(final String message) {
		super(message);
	}

	public PositionOutOfBoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public PositionOutOfBoundException(final Throwable cause) {
		super(cause);
	}

}
