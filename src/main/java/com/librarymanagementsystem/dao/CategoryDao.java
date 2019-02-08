package com.librarymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.entity.Category;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
public interface CategoryDao {
	public List<Category> fetchGategories();

	public String save(Category category);

	public String update(Category category);

	public Boolean delete(Integer id);
}
