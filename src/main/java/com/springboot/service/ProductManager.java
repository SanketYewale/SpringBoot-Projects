package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.model.Product;

public interface ProductManager {
	
	Product getProduct(int id);
	
	List<Product> getAllProducts();
	
	void deleteById(int pid);
	
	void updateProduct(Product product , int id);
	
	void saveProduct(Product p);
}
