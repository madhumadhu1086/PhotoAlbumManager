package org.photomanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.photomanager.daoservice.UserDao;
import org.photomanager.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserDAOImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> fetchAllUsers() {
		Session session = this.sessionFactory.openSession();

		List<UserModel> userList = session.createQuery("FROM UserModel").list();
		session.close();

		return userList;
	}

	public UserModel getUser(int id) {
		Session session = this.sessionFactory.openSession();
		UserModel user = (UserModel) session.get(UserModel.class, new Integer(id));
		return user;
	}

	public UserModel addUser(UserModel user) {
		Session session = this.sessionFactory.openSession();
		session.save(user);
		session.close();
		return user;
	}

	public void updateUser(UserModel user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();

		
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		UserModel p = (UserModel) session.get(UserModel.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		tx.commit();
		session.close();
	}

	@Override
	@Transactional
	public void saveAll(List<UserModel> usersList) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for (UserModel user : usersList) {
			session.save(user);
		}
		tx.commit();
		session.close();

	}

}
