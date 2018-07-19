package com.niit.ComputerBackEnd.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ComputerBackEnd.Model.Product;
import com.niit.ComputerBackEnd.Model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user) {
		
		sessionFactory.getCurrentSession().save(user);
		return true;
		
	}

	@Override
	public boolean updateDetail(UserDetail user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		
	}

	@Override
	public UserDetail getUserDetail(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class,username);
		session.close();
		return user;
	}
	public List<UserDetail> listUser() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> listUser=query.list();
		session.close();
		return listUser;
	}

	@Override
	public UserDetail validate(String username, String password) {
		
		return (UserDetail) sessionFactory.getCurrentSession().createCriteria(UserDetail.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).uniqueResult();
	}

	
}
