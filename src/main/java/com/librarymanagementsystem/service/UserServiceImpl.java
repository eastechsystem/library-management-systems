package com.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.librarymanagementsystem.dao.UserDao;
import com.librarymanagementsystem.entity.User;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> fetchUsers() {
		return userDao.fetchUsers();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String save(User user) {
		try {
			return userDao.save(user);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String update(User user) {
		try {
			return userDao.update(user);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean delete(Integer userId) {
		try {
			return userDao.delete(userId);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
