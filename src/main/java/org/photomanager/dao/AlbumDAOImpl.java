package org.photomanager.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.photomanager.daoservice.AlbumDao;
import org.photomanager.model.AlbumModel;
import org.photomanager.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlbumDAOImpl implements AlbumDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AlbumModel> fetchAllAlbums() {
		Session session = this.sessionFactory.openSession();
		List<AlbumModel> albumList = session.createQuery("from AlbumModel").list();
		session.close();

		return albumList;
	}

	public AlbumModel getAlbum(int id) {
		Session session = this.sessionFactory.openSession();

		AlbumModel album = (AlbumModel) session.get(AlbumModel.class, new Integer(id));
		return album;
	}

	public AlbumModel addAlbum(AlbumModel album) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(album);
		tx.commit();
		return album;
	}

	public void updateAlbum(AlbumModel album) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.update(album);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteAlbum(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		AlbumModel p= (AlbumModel) session.get(AlbumModel.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		tx.commit();
		session.close();

	}

	
	
	@Override
	public void saveAll(List<AlbumModel> AlbumList) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Set<AlbumModel> list=new HashSet<AlbumModel>();
		list.addAll(AlbumList);
		int temp = 0;

		for (AlbumModel album : list) {
			if(temp==10)
			{
			break;
			}
			session.save(album);

		}
		tx.commit();
		session.close();

	}

	}	

