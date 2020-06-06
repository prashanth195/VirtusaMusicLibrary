package com.virtusa.spring.music.library.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtusa.spring.music.library.exception.ArtistAlreadyExistException;
import com.virtusa.spring.music.library.model.Artist;
import com.virtusa.spring.music.library.repository.ArtistRepository;

@Component
public class ArtistService {

	@Autowired
    private ArtistRepository artistRepository;
	
	public Artist saveArtistDetails(Artist artist) throws ArtistAlreadyExistException {
		Optional<Artist> exitingArtist = artistRepository.findById(artist.getId());
		if(exitingArtist.isPresent()){
			throw new ArtistAlreadyExistException("Artist already Exits");
		}else{
			return artistRepository.save(artist);
		}

	}
	
	public List<Artist> retrieveArtistsList() throws ArtistAlreadyExistException {
		final List<Artist> artistList = new ArrayList<Artist>();
		artistRepository.findAll().forEach(artist -> artistList.add(artist));
        List<Artist> sortedList = artistList.stream()
			.sorted(Comparator.comparing(Artist::getName))
			.collect(Collectors.toList());
        
        return sortedList;
	}
	
	public Artist updateArtistDetails(Integer artistId,Artist artist) throws ArtistAlreadyExistException {
		Optional<Artist> exitingArtist = artistRepository.findById(artistId);
		  
        if(exitingArtist.isPresent()) 
        {
        	Artist newArtist = exitingArtist.get();
        	newArtist.setName(artist.getName());
        	newArtist = artistRepository.save(newArtist);
             
            return newArtist;
        } else {
        	artist = artistRepository.save(artist);
             
            return artist;
        }

	}
}
