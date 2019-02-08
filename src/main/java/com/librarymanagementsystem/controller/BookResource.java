package com.librarymanagementsystem.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.logging.Logger;
import com.librarymanagementsystem.service.BookService;

import pk.com.telenorbank.librarymanagementsystem.util.Constant;
import pk.com.telenorbank.librarymanagementsystem.util.Infrastructure;
import pk.com.telenorbank.librarymanagementsystem.util.ResourcesUtil;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@RestController
@RequestMapping("/api/v1.0")
@Controller
public class BookResource {
	@Autowired
	private Gson gson;

	@Autowired
	private BookService bookService;

	LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
	
	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(BookResource.class.getName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * fetchBookList() method is use to fetch all books from the system.
	 * 
	 * @param headers
	 * @return Json list of {@link java.lang.String} type
	 */
	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchBookList(@RequestHeader HttpHeaders headers) {
		logger.log("API: books | Method: GET | Opertaion: retrieve-books/fetch-book-list");
		
		try {
			List<Book> books = new ArrayList<Book>();
			books = bookService.fetchBooks();
			response.put("books", books);
		} catch (Exception e) {
			logger.log(e);
		}
		
		logger.log("Opertaion: fetch-book-list | ResponseBody ==> " + gson.toJson(response));
		
		return gson.toJson(response);
	}

	/**
	 * createBook() method is use for create new book record into the system.
	 * 
	 * @param bookDetails
	 * @param headers
	 * @return
	 */
	@RequestMapping(value = "/books", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createBook(@RequestBody Book bookDetails, @RequestHeader HttpHeaders headers) {
		logger.log("API: books | Method: POST | Opertaion: create-books/add-books");
		logger.log("Opertaion: create-books | RequestBody ==> " + gson.toJson(bookDetails));
		
		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			String message = "";
			message = bookService.save(bookDetails);

			if (!Constant.SUCCESS.equalsIgnoreCase(message)) {
				status = HttpStatus.NOT_FOUND;
			} else {
				status = HttpStatus.CREATED;
			}

		} catch (Exception e) {
			logger.log(e);
		}

		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: create-books | ResponseBody ==> " + populatedJsonResponseMessage);

		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}

	/**
	 * updateBook() method is use for update the existing book record into the
	 * system.
	 * 
	 * @param bookDetails
	 * @param headers
	 * @return
	 */
	@RequestMapping(value = "/books", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateBook(@RequestBody Book bookDetails, @RequestHeader HttpHeaders headers) {
		logger.log("API: books | Method: PUT | Opertaion: update-books/modify-books");
		logger.log("Opertaion: update-books | RequestBody ==> " + gson.toJson(bookDetails));
		
		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			String message = "";
			message = bookService.update(bookDetails);

			if (!Constant.SUCCESS.equalsIgnoreCase(message)) {
				status = HttpStatus.NOT_FOUND;
			} else {
				status = HttpStatus.CREATED;
			}

		} catch (Exception e) {
			logger.log(e);
		}
		
		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: update-books | ResponseBody ==> " + populatedJsonResponseMessage);

		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}

	/**
	 * deleteBookById() method is use for delete the book record from system.
	 * 
	 * @param identifier
	 * @return
	 */
	@RequestMapping(value = "/books/{identifier}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBookById(@PathVariable("identifier") int identifier) {
		logger.log("API: books | Method: DELETE | Opertaion: delete-books/remove-books");
		logger.log("Opertaion: delete-books | RequestParameter as BookId ==> " + identifier);
		
		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			Boolean isDeleted = bookService.delete(identifier);

			if (Boolean.TRUE.equals(isDeleted)) {
				status = HttpStatus.OK;
			} else {
				status = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			logger.log(e);
		}
		
		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: delete-books | ResponseBody ==> " + identifier);
		
		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}
}
