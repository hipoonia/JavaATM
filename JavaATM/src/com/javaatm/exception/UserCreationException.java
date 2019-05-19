package com.javaatm.exception;
import java.security.NoSuchAlgorithmException;

public class UserCreationException extends RuntimeException {

	public UserCreationException(NoSuchAlgorithmException e) {
		// TODO Auto-generated constructor stub
		super(e);
	}

	public UserCreationException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3470693729033783351L;
	
	

}
