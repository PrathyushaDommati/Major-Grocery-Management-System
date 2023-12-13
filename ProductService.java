package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	 Product saveProduct(Product product); 
	   List<Product> getAllProducts(); 
	   Product getProductById(long id); 
	   Product updateProduct(Product product,Long id);
	    void deleteProduct(long id);
}

