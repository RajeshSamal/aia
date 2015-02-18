package com.aia.common.exception;


/**
 * This class represents an error in the data access layer of the application
 * 
 *
 */
public class DAOException extends Exception {

	/** Auto generated UID */
	private static final long serialVersionUID = 3666231023541999514L;

	/**
	 * Default constructor which is constructed with a default message
	 */
	public DAOException() {
		this("Unknown error occured in the system.");
	}
	
	/**
	 * Constructor accepting message
	 * @param emsg the error message
	 */
	public DAOException(String emsg) {
		super(emsg);
	}
	
	/**
	 * Constructor with any {@link Throwable} instance
	 * @param error the {@link Throwable} instance
	 */
	public DAOException(Throwable error) {
		super(error);
	}
	
	/**
	 * Constructor with an error message a instance of throwable
	 * @param emsg the error message
	 * @param error the instance of the {@link Throwable}
	 */
	public DAOException(String emsg, Throwable error) {
		super(emsg, error);
	}

	
}
