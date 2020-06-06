package com.virtusa.spring.music.library.data;
//Class used for POST Mapping
public class AristData {

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

	@Override
	public String toString() {
		return "AristData [artistName=" + artistName + ", artistId=" + artistId + ", language=" + language
				+ ", getArtistName()=" + getArtistName() + ", getArtistId()=" + getArtistId() + ", getLanguage()="
				+ getLanguage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public AristData(String artistName, String artistId, String language) {
		super();
		this.artistName = artistName;
		this.artistId = artistId;
		this.language = language;
	}

	public AristData() {
		super();
	}
	
}
