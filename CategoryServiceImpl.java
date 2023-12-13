package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepo;
	public CategoryServiceImpl(CategoryRepository categoryRepo) {
		super();
		this.categoryRepo=categoryRepo;
	}
	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).orElseThrow(()->new ResourceNotFound("Category","Id","id"));
	}

	@Override
	public Category updateCategory(Category category, Long id) {
		Category existCategory=categoryRepo.findById(id).orElseThrow(()->new ResourceNotFound("Category","Id","id"));
		existCategory.setName(category.getName());
		return existCategory;
	}

	@Override
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		categoryRepo.findById(id).orElseThrow(()->new ResourceNotFound("Category","Id","id"));
		categoryRepo.deleteById(id);
	}

}

