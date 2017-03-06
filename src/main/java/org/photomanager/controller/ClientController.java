package org.photomanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.photomanager.model.AlbumModel;
import org.photomanager.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ModelAndView intestdex() {
		final String SERVER_URI = "http://localhost:2020/SpringRestHibernateExample/getAllUsers";
		List<UserModel> usersList = new ArrayList<UserModel>();

		usersList = restObject(SERVER_URI);
		Map<String, List<UserModel>> model = new HashMap<String, List<UserModel>>();
		model.put("usersList", usersList);
		return new ModelAndView("usersList", model);

	}
	
	@RequestMapping(value = "/listAlbums", method = RequestMethod.GET)
	public ModelAndView fecthAlbums() {
		final String SERVER_URI = "http://localhost:2020/SpringRestHibernateExample/getAllAlbums";
		List<AlbumModel> albumList = new ArrayList<AlbumModel>();

		RestTemplate restTemplate = new RestTemplate();
	AlbumModel albums[] = restTemplate.getForObject(SERVER_URI, AlbumModel[].class);
		for (AlbumModel album : albums) {
			albumList.add(album);

		}
	
		Map<String, List<AlbumModel>> model = new HashMap<String, List<AlbumModel>>();
		model.put("albumList", albumList);
		return new ModelAndView("albumList", model);

	}


	private List<UserModel> restObject(String url) {
		RestTemplate restTemplate = new RestTemplate();
		List<UserModel> usersList = new ArrayList<UserModel>();
		UserModel users[] = restTemplate.getForObject(url, UserModel[].class);
		for (UserModel user : users) {
			usersList.add(user);

		}
		return usersList;
	}

	@RequestMapping(value = "/listPhotos", method = RequestMethod.GET)
	public ModelAndView getPhotos() {
		final String SERVER_URI = "http://localhost:2020/SpringRestHibernateExample/getAllPhotos";
		RestTemplate restTemplate = new RestTemplate();
		List<PhotoModel> photoList = new ArrayList<PhotoModel>();
		PhotoModel photos[] = restTemplate.getForObject(SERVER_URI, PhotoModel[].class);
		for (PhotoModel user : photos) {
			photoList.add(user);
			
		}
		ConcurrentHashMap<String, List<PhotoModel>> model =new ConcurrentHashMap<>() ;
		model.put("photoList", photoList);
		return new ModelAndView("photoList", model);

	}

}
