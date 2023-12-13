package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	private ProductRepository productRepo;
	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo=productRepo;
	}
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		return productRepo.findById(id).orElseThrow(()->new ResourceNotFound("Product","Id","id"));
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		Product existproduct=productRepo.findById(id).orElseThrow(()->new ResourceNotFound("Product","Id","id"));
		existproduct.setName(product.getName());
		existproduct.setCategoryName(product.getCategoryName());
		existproduct.setDescription(product.getDescription());
		existproduct.setPrice(product.getPrice());
		existproduct.setImage(product.getImage());
		productRepo.save(existproduct);
		return existproduct;
	}

	@Override
	public void deleteProduct(long id) {
		productRepo.findById(id).orElseThrow(()->new ResourceNotFound("Product","Id","id"));
		productRepo.deleteById(id);
		
	}

}

