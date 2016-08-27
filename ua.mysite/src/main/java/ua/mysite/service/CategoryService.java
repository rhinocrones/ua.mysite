package ua.mysite.service;

import java.util.List;

import ua.mysite.entity.Category;

public interface CategoryService {

	void save(String category);
	
	Category findByCategory(String category);
	
	void deleteByCategory(String category);
	
	List<Category> findAll();
}
