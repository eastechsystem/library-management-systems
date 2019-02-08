package com.librarymanagementsystem.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.librarymanagementsystem.entity.Category;
import com.librarymanagementsystem.logging.Logger;
import com.librarymanagementsystem.service.CategoryService;

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
public class CategoryResource {

	@Autowired
	private Gson gson;

	@Autowired
	private CategoryService categoryService;

	LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
	
	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(CategoryResource.class.getName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * sayHello() is a test method to test whether Web service is accessible or not
	 * 
	 * @return response of type {@link java.lang.String} type
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		String result = "Hello World! This is Library Management RestWeb Service v1.0 (" + (new Date()).toString() + ").";
		return result;
	}

	/**
	 * fetchCategoryList() method is use to fetch all categories from system.
	 * 
	 * @param headers
	 * @return Json list of {@link java.lang.String} type
	 */
	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchCategoryList(@RequestHeader HttpHeaders headers) {
		logger.log("API: categories | Method: GET | Opertaion: retrieve-categories/fetch-categories-list");
		
		try {
			List<Category> categories = new ArrayList<Category>();
			categories = categoryService.fetchGategories();
			response.put("categories", categories);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.log("Opertaion: fetch-categories-list | ResponseBody ==> " + gson.toJson(response));
		
		return gson.toJson(response);
	}

	/**
	 * createCategory() method is use for create new category record into the
	 * system.
	 * 
	 * @param categoryDetails
	 * @param headers
	 * @return
	 */
	@RequestMapping(value = "/categories", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCategory(@RequestBody Category categoryDetails, @RequestHeader HttpHeaders headers) {
		logger.log("API: categories | Method: POST | Opertaion: create-categories/add-categories");
		logger.log("Opertaion: create-categories | RequestBody ==> " + gson.toJson(categoryDetails));
		
		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			String message = "";
			message = categoryService.save(categoryDetails);

			if (!Constant.SUCCESS.equalsIgnoreCase(message)) {
				status = HttpStatus.NOT_FOUND;
			} else {
				status = HttpStatus.CREATED;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: create-categories | ResponseBody ==> " + populatedJsonResponseMessage);

		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}

	/**
	 * updateCategory() method is use for update the existing category record into
	 * the system.
	 * 
	 * @param categoryDetails
	 * @param headers
	 * @return
	 */
	@RequestMapping(value = "/categories", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCategory(@RequestBody Category categoryDetails, @RequestHeader HttpHeaders headers) {
		logger.log("API: categories | Method: PUT | Opertaion: update-categories/modify-categories");
		logger.log("Opertaion: update-categories | RequestBody ==> " + gson.toJson(categoryDetails));
		
		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			String message = "";
			message = categoryService.update(categoryDetails);

			if (!Constant.SUCCESS.equalsIgnoreCase(message)) {
				status = HttpStatus.NOT_FOUND;
			} else {
				status = HttpStatus.CREATED;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: update-categories | ResponseBody ==> " + populatedJsonResponseMessage);
		
		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}

	/**
	 * deleteCategoryById() method is use for delete the category record from
	 * system.
	 * 
	 * @param identifier
	 * @return
	 */
	@RequestMapping(value = "/categories/{identifier}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCategoryById(@PathVariable("identifier") int identifier) {
		logger.log("API: categories | Method: DELETE | Opertaion: delete-categories/remove-categories");
		logger.log("Opertaion: delete-categories | RequestParameter as CategoryId ==> " + identifier);
		
		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			Boolean isDeleted = categoryService.delete(identifier);

			if (Boolean.TRUE.equals(isDeleted)) {
				status = HttpStatus.OK;
			} else {
				status = HttpStatus.NOT_FOUND;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: delete-categories | ResponseBody ==> " + identifier);
		
		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}

}
