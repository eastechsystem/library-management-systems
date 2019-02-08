package com.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.librarymanagementsystem.dao.BookDao;
import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.entity.User;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Book> fetchBooks() {
		return bookDao.fetchBooks();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String save(Book book) {
		try {
			return bookDao.save(book);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String update(Book book) {
		try {
			return bookDao.update(book);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean delete(Integer bookId) {
		try {
			return bookDao.delete(bookId);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
