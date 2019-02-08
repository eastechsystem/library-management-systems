package com.librarymanagementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.entity.Category;
import com.librarymanagementsystem.entity.User;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@Component
public class CategoryDaoHibernateImpl extends AbstractHibernateDao implements CategoryDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> fetchGategories() {
		Session session = null;
		try {
			session = getOpendSession();
			Criteria criteria = session.createCriteria(Category.class);
			List<Category> contacts = criteria.list();

			return contacts;
		} catch (HibernateException ex) {
			throw ex;
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
	}
	
	@Override
	public String save(Category category) {
		String message = SUCCESS;
		if (category == null) {
			message = FAILURE + " - null instance cannot be saved or updated";
			return message;
		}

		Session session = null;
		try {
			if (category.getId() == null) {
				session = getOpendSession();
				session.saveOrUpdate(category);
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
	public String update(Category category) {
		String message = SUCCESS;
		if (category == null) {
			message = FAILURE + " - null instance cannot be saved or updated";
			return message;
		}

		Session session = null;
		try {
			if (category.getId() != null) {
				session = getOpendSession();
				session.merge(category);
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
			Category category = (Category) session.load(Category.class, id);
			session.delete(category);
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
