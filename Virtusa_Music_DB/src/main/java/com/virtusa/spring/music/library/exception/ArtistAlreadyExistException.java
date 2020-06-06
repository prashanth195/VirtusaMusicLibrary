package com.virtusa.spring.music.library.exception;

public class ArtistAlreadyExistException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public ArtistAlreadyExistException(String message) {

		super(message);
	}
}
