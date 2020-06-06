package com.virtusa.spring.music.library.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.spring.music.library.exception.ArtistAlreadyExistException;
import com.virtusa.spring.music.library.model.Artist;
import com.virtusa.spring.music.library.service.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@GetMapping("/health")
	public String health(){
		return "I am alive";
	}
	
	@PostMapping("/artists")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Artist> saveArtistInfo(@RequestBody Artist artist) throws ArtistAlreadyExistException, ServletException
	 {
		HttpHeaders headers=new HttpHeaders();	
		if(artist==null){
			return new ResponseEntity<Artist>(artist,headers,HttpStatus.BAD_REQUEST);
		}
		try{
			artist= artistService.saveArtistDetails(artist);
			if(artist != null){
				headers.add("artist created -",String.valueOf(artist.getId()));
				return new ResponseEntity<Artist>(headers,HttpStatus.CREATED);
			}else{
				return new ResponseEntity<Artist>(headers,HttpStatus.CONFLICT);
			}
		}catch(Exception ex){
			return new ResponseEntity<Artist>(headers,HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/artists")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Artist>> getAllArtists(){
		HttpHeaders headers=new HttpHeaders();
		List<Artist> artistList=new ArrayList<Artist>();
		try{
			artistList = artistService.retrieveArtistsList();
			
			return new ResponseEntity<List<Artist>>(artistList,headers,HttpStatus.OK);
			
		}catch(Exception ex){
			
			return new ResponseEntity<List<Artist>>(artistList,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/artists/{artistId}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Artist> updateArtists(@PathVariable Integer artistId,@RequestBody Artist artist){
		HttpHeaders headers=new HttpHeaders();	
		if(artistId==null){
			return new ResponseEntity<Artist>(artist,headers,HttpStatus.BAD_REQUEST);
		}
		try{
			artist= artistService.updateArtistDetails(artistId,artist);
			if(artist != null){
				headers.add("artist updated -",String.valueOf(artist.getId()));
				return new ResponseEntity<Artist>(headers,HttpStatus.CREATED);
			}else{
				return new ResponseEntity<Artist>(headers,HttpStatus.CONFLICT);
			}
		}catch(Exception ex){
			return new ResponseEntity<Artist>(headers,HttpStatus.CONFLICT);
		}
		
	}
	

}