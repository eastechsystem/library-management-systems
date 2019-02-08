package com.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.librarymanagementsystem.dao.CategoryDao;
import com.librarymanagementsystem.entity.Category;

/**
 * @author Jahanzaib Ali
 * @since Feb 09, 2019
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Category> fetchGategories() {
		return categoryDao.fetchGategories();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String save(Category category) {
		try {
			return categoryDao.save(category);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String update(Category category) {
		try {
			return categoryDao.update(category);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean delete(Integer categoryId) {
		try {
			return categoryDao.delete(categoryId);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
