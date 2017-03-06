package org.photomanager.daoservice;

import java.util.List;

import org.photomanager.model.PhotoModel;
import org.photomanager.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface PhotoDao {


	public PhotoModel getPhoto(int id);

	public void updatePhoto(PhotoModel photo);

	public void deletePhoto(int id);

	public PhotoModel addPhoto(PhotoModel photo);

	public void saveAll(List<PhotoModel> photoList);

	public List<PhotoModel> fetchAllPhotos();

}
