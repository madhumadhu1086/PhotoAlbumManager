package org.photomanager.daoservice;

import java.util.List;

import org.photomanager.model.UserModel;

public interface UserDao {

		void saveAll(List<UserModel> usersList);
		public void updateUser(UserModel user);
		public UserModel addUser(UserModel user);
		public UserModel getUser(int id);
		public void deleteUser(int id);
		public List<UserModel> fetchAllUsers();


		

		
	
}
