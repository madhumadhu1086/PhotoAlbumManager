package org.photomanager.daoservice;

import java.util.List;

import org.photomanager.model.AlbumModel;

public interface AlbumDao {

	public List<AlbumModel> fetchAllAlbums();

	public AlbumModel getAlbum(int id);

	public AlbumModel addAlbum(AlbumModel album);

	public void deleteAlbum(int id);

	void updateAlbum(AlbumModel album);
	public void saveAll(List<AlbumModel> albumList);


}
