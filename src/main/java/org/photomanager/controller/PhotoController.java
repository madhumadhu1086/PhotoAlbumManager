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

import org.photomanager.daoservice.PhotoDao;
import org.photomanager.model.*;

@RestController
public class PhotoController {
	@Autowired
	PhotoDao photoDao;

	@RequestMapping(value = "/getAllPhotos", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<PhotoModel> getPhotos() {
		final String uri = "https://jsonplaceholder.typicode.com/photos";

		RestTemplate restTemplate = new RestTemplate();
		PhotoModel phots[] = restTemplate.getForObject(uri, PhotoModel[].class);
		List<PhotoModel> photoList = new ArrayList<PhotoModel>();
		for (PhotoModel photo : phots) {
			photoList.add(photo);
		}
		photoDao.saveAll(photoList);

		return photoList;
	}

	@RequestMapping(value = "/fetchAllPhotos", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<PhotoModel> fetchUsers() {

		return photoDao.fetchAllPhotos();

	}

	// get the photo
	@RequestMapping(value = "/get/photo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public PhotoModel getPhoto(@PathVariable int id) {
		PhotoModel photo = photoDao.getPhoto(id);

		return photo;
	}

	// add photo
	@RequestMapping(value = "/add/photo", method = RequestMethod.POST, headers = "Accept=application/json")
	public PhotoModel addPhoto(@RequestBody PhotoModel photo) {
		return photoDao.addPhoto(photo);
	}

	// delete photo
	@RequestMapping(value = "/delete/photo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deletePhoto(@PathVariable("id") int id) {
		photoDao.deletePhoto(id);
	}

	// update photo method
	@RequestMapping(value = "/update/photo/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void update(@PathVariable int id, @RequestBody PhotoModel photo) {

		PhotoModel currentPhoto = photoDao.getPhoto(id);

		if (currentPhoto != null) {
			currentPhoto.setTitle(photo.getTitle());
			currentPhoto.setUrl(photo.getUrl());
			currentPhoto.setAlbumId(photo.getAlbumId());

			photoDao.updatePhoto(currentPhoto);

		}
	}

}
