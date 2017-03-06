package org.photomanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import org.photomanager.daoservice.AlbumDao;
import org.photomanager.model.*;

@RestController
public class AlbumController {
	@Autowired
	AlbumDao albumDao;

	@RequestMapping(value = "/getAllAlbums", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<AlbumModel> getAlbums() {
		final String uri = "https://jsonplaceholder.typicode.com/albums";

		RestTemplate restTemplate = new RestTemplate();
		AlbumModel albums[] =  restTemplate.getForObject(uri, AlbumModel[].class);
		List<AlbumModel> albumList = new ArrayList<>();
		for (AlbumModel album : albums) {
			albumList.add(album);

		}
		albumDao.saveAll(albumList);
		return albumList;
	}
	@RequestMapping(value = "/fetchAllAlbums", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<AlbumModel> fetchUsers() {

		return albumDao.fetchAllAlbums();

	}

	
	// get the album
	@RequestMapping(value = "/get/album/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AlbumModel getPhoto(@PathVariable int id) {
		AlbumModel album = albumDao.getAlbum(id);

		return album;
	}

	// Add
	@RequestMapping(value = "/add/album", method = RequestMethod.POST, headers = "Accept=application/json")
	public AlbumModel addPhoto(@RequestBody AlbumModel album) {
		return albumDao.addAlbum(album);
	}

	// delete
	@RequestMapping(value = "/delete/album/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteAlbum(@PathVariable("id") int id) {
		albumDao.deleteAlbum(id);
	}

	// update method

	@RequestMapping(value = "/update/album/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void update(@PathVariable int id, @RequestBody AlbumModel album) {

		AlbumModel currentAlbum = albumDao.getAlbum(id);

		if (currentAlbum != null) {
			currentAlbum.setId(album.getId());
			currentAlbum.setTitle(album.getTitle());
			currentAlbum.setUserId(album.getUserId());

			albumDao.updateAlbum(currentAlbum);

		}
	}

}
