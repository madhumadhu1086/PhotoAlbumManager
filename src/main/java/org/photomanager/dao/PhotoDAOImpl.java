package org.photomanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.photomanager.daoservice.PhotoDao;
import org.photomanager.model.PhotoModel;
import org.photomanager.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PhotoDAOImpl implements PhotoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhotoModel> fetchAllPhotos() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<PhotoModel> photoList = session.createQuery("FROM PhotoModel").list();
		tx.commit();
		session.close();

		return photoList;
	}

	public PhotoModel getPhoto(int id) {
		Session session = this.sessionFactory.openSession();
		PhotoModel photo = (PhotoModel) session.get(PhotoModel.class, new Integer(id));
		session.close();

		return photo;
	}

	public PhotoModel addPhoto(PhotoModel photo) {
		Session session = this.sessionFactory.openSession();
		session.save(photo);
		session.close();

		return photo;
	}

	public void updatePhoto(PhotoModel photo) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.update(photo);
		tx.commit();
		session.close();
	}

	public void deletePhoto(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		PhotoModel p = (PhotoModel) session.get(PhotoModel.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		tx.commit();
		session.close();

	}

	@Override
	@Transactional
	public void saveAll(List<PhotoModel> usersList) {
		Session session = this.sessionFactory.openSession();
		if (!usersList.isEmpty()) {
			int temp = 0;
			for (PhotoModel user : usersList) {
				temp++;
				if (temp == 10) {
					break;
				}
				session.save(user);

			}
			session.close();

		}
	}

}
