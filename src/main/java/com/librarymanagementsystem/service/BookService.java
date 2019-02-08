package com.librarymanagementsystem.service;

import java.util.List;

import com.librarymanagementsystem.entity.Book;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
public interface BookService {

	public List<Book> fetchBooks();

	public String save(Book book);

	public String update(Book book);

	public Boolean delete(Integer bookId);

}
