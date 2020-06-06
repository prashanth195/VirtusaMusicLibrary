package com.virtusa.spring.prashanth.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.virtusa.spring.prashanth.data.AristData;
import com.virtusa.spring.prashanth.model.Album;
import com.virtusa.spring.prashanth.model.Artist;

@RestController
@RequestMapping("/artists")
public class MusicDBController {
	
	Map<String, Artist> artist;
	
	//GET ARTIST BY ID 
	
	@GetMapping(path ="/{artistId}")
	public ResponseEntity<Artist> getArtists(@PathVariable String artistId) {
		if(artist.containsKey(artistId)) {
			return new ResponseEntity<Artist>(artist.get(artistId),HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<Artist>(HttpStatus.NO_CONTENT); 
		}
		
		/*
		 * List<Artist> art = new ArrayList<Artist>(); art.add(new
		 * Artist("ARR",001,"Tamil")); art.add(new Artist("ILR",002,"Tamil"));
		 * art.add(new Artist("YSR",003,"Tamil")); art.add(new
		 * Artist("DSP",004,"Tamil")); art.add(new Artist("HRJ",005,"Tamil")); //Artist
		 * art = new Artist(); System.out.println("List is"+art); return art;
		 */
	}
	
	//CREATE ARTIST 
	/**
	 * 
	 * URL : localhost:9100/artists
	 * 
	 * JSON PAYLOAD DATA
	 	{
        "artistName": "ILR",
        "artistId": 2,
        "language": "Tamil"
    	},
     
	 */
	
	@PostMapping()
	public Artist createArtist(@RequestBody AristData artdata) {
		Artist art = new Artist();
		art.setArtistId(artdata.getArtistId());
		art.setArtistName(artdata.getArtistName());
		art.setLanguage(artdata.getLanguage());
		System.out.println("ARTIST DATA CREATED :"+art);
		
		
		String artistId = UUID.randomUUID().toString();
		art.setArtistId(artistId);
		if(artist==null) artist = new HashMap<>();
		artist.put(artistId, art);
		return art;
	}
	
	@PutMapping(path ="/{artistId}")
	public Artist updateArtist(@PathVariable String artistId,@RequestBody AristData artdata) {
		Artist storedArt = artist.get(artistId);
		storedArt.setArtistId(artdata.getArtistId());
		storedArt.setArtistName(artdata.getArtistName());
		storedArt.setLanguage(artdata.getLanguage());
		artist.put(artistId, storedArt);
		return storedArt;
	}
	
	@GetMapping(path = "/{artistId}/{albums}")
	public String getAlbum(@PathVariable String albums) {
		return "Hello Albums";
		
	}

}
