package com.librarymanagementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.librarymanagementsystem.entity.User;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@Component
public class UserDaoHibernateImpl extends AbstractHibernateDao implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> fetchUsers() {
		Session session = null;
		try {
			session = getOpendSession();
			Criteria criteria = session.createCriteria(User.class);
			List<User> users = criteria.list();

			return users;
		} catch (HibernateException ex) {
			throw ex;
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
	}

	@Override
	public String save(User user) {
		String message = SUCCESS;
		if (user == null) {
			message = FAILURE + " - null instance cannot be saved or updated";
			return message;
		}

		Session session = null;
		try {
			if (user.getId() == null) {
				session = getOpendSession();
				session.saveOrUpdate(user);
			} else {
				message = FAILURE;
			}
		} catch (HibernateException ex) {
			message = FAILURE;
			throw ex;
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}

		return message;
	}
	
	@Override
	public String update(User user) {
		String message = SUCCESS;
		if (user == null) {
			message = FAILURE + " - null instance cannot be saved or updated";
			return message;
		}

		Session session = null;
		try {
			if (user.getId() != null) {
				session = getOpendSession();
				session.merge(user);
				session.flush();
			} else {
				message = FAILURE;
			}
		} catch (HibernateException ex) {
			message = FAILURE;
			throw ex;
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}

		return message;
	}
	
	@Override
	public Boolean delete(Integer id) {
		Boolean isDeleted = false;
		Session session = null;

		try {
			session = getOpendSession();
			User user = (User) session.load(User.class, id);
			session.delete(user);
			session.flush();
			isDeleted = true;
		} catch (HibernateException ex) {
			throw ex;
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}

		return isDeleted;
	}
}
