package com.librarymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.entity.User;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
public interface UserDao {

	public List<User> fetchUsers();

	public String save(User user);

	public Boolean delete(Integer id);

	public String update(User user);

}
