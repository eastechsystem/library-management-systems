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
import com.librarymanagementsystem.entity.User;
import com.librarymanagementsystem.logging.Logger;
import com.librarymanagementsystem.service.UserService;

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
public class UserResource {
	@Autowired
	private Gson gson;

	@Autowired
	private UserService userService;

	LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();

	private static Logger logger = null;

	static {
		try {
			logger = Infrastructure.getLogger(UserResource.class.getName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * fetchUserList() method is use to fetch all users from the system. retrieve
	 * 
	 * @param headers
	 * @return Json list of {@link java.lang.String} type
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchUserList(@RequestHeader HttpHeaders headers) {
		logger.log("API: users | Method: GET | Opertaion: retrieve-users/fetch-user-list");

		try {
			List<User> users = new ArrayList<User>();
			users = userService.fetchUsers();
			response.put("users", users);
		} catch (Exception e) {
			logger.log(e);
		}

		logger.log("Opertaion: fetch-user-list | ResponseBody ==> " + gson.toJson(response));

		return gson.toJson(response);
	}

	/**
	 * createUser() method is use for create new user profile into the system.
	 * 
	 * @param userInfo
	 * @param headers
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUser(@RequestBody User userInfo, @RequestHeader HttpHeaders headers) {
		logger.log("API: users | Method: POST | Opertaion: create-users/add-user");
		logger.log("Opertaion: create-users | RequestBody ==> " + gson.toJson(userInfo));

		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			String message = "";
			message = userService.save(userInfo);

			if (!Constant.SUCCESS.equalsIgnoreCase(message)) {
				status = HttpStatus.NOT_FOUND;
			} else {
				status = HttpStatus.CREATED;
			}

		} catch (Exception e) {
			logger.log(e);
		}

		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: create-users | ResponseBody ==> " + populatedJsonResponseMessage);

		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}

	/**
	 * updateUser() method is use for update the existing user profile into the
	 * system.
	 * 
	 * @param userInfo
	 * @param headers
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUser(@RequestBody User userInfo, @RequestHeader HttpHeaders headers) {
		logger.log("API: users | Method: PUT | Opertaion: update-users/modify-user");
		logger.log("Opertaion: update-users | RequestBody ==> " + gson.toJson(userInfo));

		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			String message = "";
			message = userService.update(userInfo);

			if (!Constant.SUCCESS.equalsIgnoreCase(message)) {
				status = HttpStatus.NOT_FOUND;
			} else {
				status = HttpStatus.CREATED;
			}

		} catch (Exception e) {
			logger.log(e);
		}

		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: update-users | ResponseBody ==> " + populatedJsonResponseMessage);

		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}

	/**
	 * deleteUserById() method is use for delete the user profile from system.
	 * 
	 * @param identifier
	 * @return
	 */
	@RequestMapping(value = "/users/{identifier}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserById(@PathVariable("identifier") int identifier) {
		logger.log("API: users | Method: DELETE | Opertaion: delete-users/remove-user");
		logger.log("Opertaion: delete-users | RequestParameter as UserId ==> " + identifier);

		String populatedJsonResponseMessage = "";
		HttpStatus status = HttpStatus.NOT_FOUND;
		try {
			Boolean isDeleted = userService.delete(identifier);

			if (Boolean.TRUE.equals(isDeleted)) {
				status = HttpStatus.OK;
			} else {
				status = HttpStatus.NOT_FOUND;
			}

		} catch (Exception e) {
			logger.log(e);
		}

		populatedJsonResponseMessage = ResourcesUtil.getPopulatedResponseMessage(status);
		logger.log("Opertaion: delete-users | ResponseBody ==> " + identifier);

		return new ResponseEntity<String>(populatedJsonResponseMessage, status);
	}
}
