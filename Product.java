package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="products")

public class Product {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 private String categoryName;
	 private String description;
	 private double price;
	 @Column(columnDefinition="MEDIUMTEXT")
	 private String image;
	public Product() {
		super();
	}
	public Product(Long id, String name, String categoryName, String description, double price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.categoryName = categoryName;
		this.description = description;
		this.price = price;
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", categoryName=" + categoryName + ", description="
				+ description + ", price=" + price + ", image=" + image + "]";
	}
	
	
	 

	 
}

