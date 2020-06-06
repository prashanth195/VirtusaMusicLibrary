package com.virtusa.spring.prashanth.model;

public class Album {
	
	private int albumId;
	
	private String albumTitle;
	
	private String albumYear;
	
	private String albumGenre;

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getAlbumYear() {
		return albumYear;
	}

	public void setAlbumYear(String albumYear) {
		this.albumYear = albumYear;
	}

	public String getAlbumGenre() {
		return albumGenre;
	}

	public void setAlbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}

	public Album() {
		super();
	}
	
	public Album(String albumTitle, String albumYear, String albumGenre) {
		super();
		this.albumTitle = albumTitle;
		this.albumYear = albumYear;
		this.albumGenre = albumGenre;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	
}
