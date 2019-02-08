package com.librarymanagementsystem.service;

import java.util.List;

import com.librarymanagementsystem.entity.User;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
public interface UserService {

	public List<User> fetchUsers();

	public String save(User User);

	public Boolean delete(Integer userId);

	public String update(User user);

}
