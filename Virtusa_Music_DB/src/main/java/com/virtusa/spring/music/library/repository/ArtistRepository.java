package com.virtusa.spring.music.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtusa.spring.music.library.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Integer>{
	 
	}
