package com.librarymanagementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BookDaoHibernateImpl extends AbstractHibernateDao implements BookDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> fetchBooks() {
		Session session = null;
		try {
			session = getOpendSession();
			Criteria criteria = session.createCriteria(Book.class);
			List<Book> contacts = criteria.list();

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
	public String save(Book book) {
		String message = SUCCESS;
		if (book == null) {
			message = FAILURE + " - null instance cannot be saved or updated";
			return message;
		}

		Session session = null;
		try {
			if (book.getId() == null) {
				session = getOpendSession();
				session.saveOrUpdate(book);
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
	public String update(Book book) {
		String message = SUCCESS;
		if (book == null) {
			message = FAILURE + " - null instance cannot be saved or updated";
			return message;
		}

		Session session = null;
		try {
			if (book.getId() != null) {
				session = getOpendSession();
				session.merge(book);
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
			Book book = (Book) session.load(Book.class, id);
			session.delete(book);
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
