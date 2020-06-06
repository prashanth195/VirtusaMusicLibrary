package com.virtusa.spring.prashanth.model;

import org.springframework.stereotype.Component;

@Component
public class Artist {
	
	private String artistName;

	private String artistId;
	
	private String language;

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Artist() {
		super();
	}

	public Artist(String artistName, String artistId, String language) {
		super();
		this.artistName = artistName;
		this.artistId = artistId;
		this.language = language;
	}

	@Override
	public String toString() {
		return "Artist [artistName=" + artistName + ", artistId=" + artistId + ", language=" + language + "]";
	}
	
	

}
