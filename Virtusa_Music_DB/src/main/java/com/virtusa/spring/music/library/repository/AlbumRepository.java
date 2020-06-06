package com.virtusa.spring.music.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.spring.music.library.model.Album;
@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>{
	 
	List<Album> findAllById(Integer artistId);
	}
