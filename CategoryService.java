package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Category;

public interface CategoryService {
	 
    Category saveCategory(Category category); 
   List<Category> getAllCategories(); 
    Category getCategoryById(long id); 
    Category updateCategory(Category category,Long id);
    void deleteCategory(long id);
	
}
