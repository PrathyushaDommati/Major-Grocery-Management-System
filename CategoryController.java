package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
    
    private CategoryController(CategoryService categoryService) {
    	super();
    	this.categoryService=categoryService;
    }
    @PostMapping
    public ResponseEntity<Category>saveCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.saveCategory(category),HttpStatus.CREATED);
    }
    @GetMapping
	public List<Category>getCategories()
	{
		return categoryService.getAllCategories();
	}
	//build get single learner RESTAPI
	@GetMapping("{id}")
	public ResponseEntity<Category>getCategoryById(@PathVariable("id")long categoryId)	
	{
		return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Category>updateCategory(@PathVariable("id")long id,@RequestBody Category category)
	{
		return new ResponseEntity<Category>(categoryService.updateCategory(category,id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteCategory(@PathVariable("id")long id)
	{
		categoryService.deleteCategory(id);
		return new ResponseEntity<String>("Category Deleted...",HttpStatus.OK);
	}
}

