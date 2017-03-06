package org.photomanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.photomanager.daoservice.UserDao;
import org.photomanager.model.*;

@RestController
public class UserController {
	@Autowired
	UserDao userService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<UserModel> getUsers() {
		final String uri = "https://jsonplaceholder.typicode.com/users";

		RestTemplate restTemplate = new RestTemplate();
		List<UserModel> usersList = new ArrayList<UserModel>();
		UserModel users[] = restTemplate.getForObject(uri, UserModel[].class);
		for (UserModel user : users) {
			System.out.println(user.getEmail());
			System.out.println(user.getName());
			usersList.add(user);

		}
		userService.saveAll(usersList);
		return usersList;
	}

	@RequestMapping(value = "/fetchAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<UserModel> fetchUsers() {

		return userService.fetchAllUsers();

	}

	// fetch the user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public UserModel getUser(@PathVariable int id) {
		UserModel user = userService.getUser(id);

		return user;
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public void create(@RequestBody UserModel user) {
		userService.addUser(user);
	}

	// delete the user
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}// update method

	@RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void update(@PathVariable int id, @RequestBody UserModel user) {
		// userService.updateUser(user);
		UserModel currentUser = userService.getUser(id);

		if (currentUser != null) {
			currentUser.setName(user.getName());
			currentUser.setEmail(user.getEmail());

			userService.updateUser(currentUser);

		}
	}

}
