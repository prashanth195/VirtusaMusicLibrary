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
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.spring.music.library.model.Album;
import com.virtusa.spring.music.library.model.Artist;
import com.virtusa.spring.music.library.service.AlbumService;

@RestController
public class AlbumController {

 @Autowired
private AlbumService albumService;
	
	@GetMapping("/health")
	public String health(){
		return "I am alive";
	}
	
	@PostMapping("/artists/{artistId}/albums")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Album> saveAlbumInfo(@RequestBody Album album,@PathVariable Integer artistId) throws  ServletException
	 {
		HttpHeaders headers=new HttpHeaders();	
		if(album==null){
			return new ResponseEntity<Album>(album,headers,HttpStatus.BAD_REQUEST);
		}
		try{
			Artist artist=new Artist();
			artist.setId(artistId);
			album.setArtist(artist);
			album= albumService.saveAlbumDetails(album);
			if(album != null){
				headers.add("album created -",String.valueOf(album.getId()));
				return new ResponseEntity<Album>(headers,HttpStatus.CREATED);
			}else{
				return new ResponseEntity<Album>(headers,HttpStatus.CONFLICT);
			}
		}catch(Exception ex){
			return new ResponseEntity<Album>(headers,HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/artists/{artistId}/albums")
	@CrossOrigin(origins = "*")
	public ResponseEntity<List<Album>> getAllAlbumByArtist(@PathVariable Integer artistId){
		HttpHeaders headers=new HttpHeaders();
		List<Album> artistAlbumList=new ArrayList<Album>();
		try{
			artistAlbumList = albumService.getAllAlbumByArtist(artistId);
			
			return new ResponseEntity<List<Album>>(artistAlbumList,headers,HttpStatus.OK);
			
		}catch(Exception ex){
			
			return new ResponseEntity<List<Album>>(artistAlbumList,headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("artists/{artistId}/albums/{albumId}")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Album> updateArtists(@PathVariable Integer artistId,@PathVariable Integer albumId){
		HttpHeaders headers=new HttpHeaders();	
		Album album=new Album();
		if(artistId==null || albumId==null){
			return new ResponseEntity<Album>(album,headers,HttpStatus.BAD_REQUEST);
		}
		try{
			album= albumService.updateAlbumForArtist(artistId,albumId);
			if(album != null){
				headers.add("Album updated -",String.valueOf(albumId));
				return new ResponseEntity<Album>(headers,HttpStatus.CREATED);
			}else{
				return new ResponseEntity<Album>(headers,HttpStatus.CONFLICT);
			}
		}catch(Exception ex){
			return new ResponseEntity<Album>(headers,HttpStatus.CONFLICT);
		}
		
	}
}
