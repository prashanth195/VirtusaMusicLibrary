package com.virtusa.spring.music.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Album {
	
	 	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
	    private String name;
	    //private Integer artistId;
	    public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		
		private String createdDate;
	    private String releaseDate;
	    @ManyToOne
	    private Artist artist;
	    @ManyToOne
	    private Genre genre;

		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public String getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}

		public String getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}

		public Artist getArtist() {
			return artist;
		}

		public void setArtist(Artist artist) {
			this.artist = artist;
		}

		public Genre getGenre() {
			return genre;
		}

		public void setGenre(Genre genre) {
			this.genre = genre;
		}


	}