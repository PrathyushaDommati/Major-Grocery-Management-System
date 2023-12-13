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

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;



@CrossOrigin("*")
@RestController
@RequestMapping("api/products")
public class ProductController {
private ProductService productService;
    
    private ProductController(ProductService productService) {
    	super();
    	this.productService=productService;
    }
    @PostMapping
    public ResponseEntity<Product>saveProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
    }
    @GetMapping
	public List<Product>getProducts()
	{
		return productService.getAllProducts();
	}
	//build get single learner RESTAPI
	@GetMapping("{id}")
	public ResponseEntity<Product>getProductById(@PathVariable("id")long productId)	
	{
		return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Product>updateProduct(@PathVariable("id")long id,@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.updateProduct(product,id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteProduct(@PathVariable("id")long id)
	{
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product Deleted...",HttpStatus.OK);
	}
}
