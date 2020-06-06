package com.virtusa.spring.music.library.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.virtusa.spring.music.library.exception.ArtistAlreadyExistException;
import com.virtusa.spring.music.library.exception.ArtistNotFoundException;
import com.virtusa.spring.music.library.model.Album;
import com.virtusa.spring.music.library.model.Artist;
import com.virtusa.spring.music.library.repository.AlbumRepository;

@Component
public class AlbumService {

	@Autowired
    private AlbumRepository albumRepository;
	
	public Album saveAlbumDetails(Album album) throws Exception {
		Optional<Album> exitingAlbum = albumRepository.findById(album.getId());
		if(exitingAlbum.isPresent()){
			throw new ArtistAlreadyExistException("Album already Exits");
		}else{
			return albumRepository.save(album);
		}

	}
	
	public List<Album> getAllAlbumByArtist(Integer artistId) throws ArtistNotFoundException {
		final List<Album> albumList = new ArrayList<Album>();
		List<Album> exitingAlbum = albumRepository.findAllById(artistId);
		if(CollectionUtils.isEmpty(exitingAlbum)){
		 exitingAlbum.forEach(album -> albumList.add(album));
	        List<Album> sortedAlbumList = exitingAlbum.stream()
				.sorted(Comparator.comparing(Album::getName))
				.collect(Collectors.toList());
	        
		return	sortedAlbumList;
			
		}else{
			throw new ArtistNotFoundException("Artist not found");
		}
		
	}
	
	public Album updateAlbumForArtist(Integer artistId,Integer albumId) throws ArtistAlreadyExistException {
		Optional<Album> exitingAlbum = albumRepository.findById(albumId);
		  
        if(exitingAlbum.isPresent()) 
        {
        	Album album = exitingAlbum.get();
        	album.setName("newAlbum");
        	Artist artist=album.getArtist();
        	if(artist.getId()==artistId){
        		artist.setSong("werts");
        		album.setArtist(artist);
        	}
        	album = albumRepository.save(album);
             
            return album;
        } else {
        	throw new RuntimeException("Album does not exists for the album id");
        }

	}
}
