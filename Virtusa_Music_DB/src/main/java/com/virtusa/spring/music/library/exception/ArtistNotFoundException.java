package com.virtusa.spring.music.library.exception;

public class ArtistNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public ArtistNotFoundException(String message) {
		super(message);
	}
}
