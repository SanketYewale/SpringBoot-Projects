package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Product;
import com.springboot.repository.ProductRepository;

@Service
public class ProductManagerImpl implements ProductManager {
	
	@Autowired
	ProductRepository repository;

	@Override
	public Product getProduct(int id) {
		
		return repository.findById(id);

	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteById(int pid) {
		
		repository.deleteById(pid);
		
	}

	@Override
	public void updateProduct(Product product, int id) {
		// TODO Auto-generated method stub
		
		repository.update(product.getName(), product.getPrice(), product.getQty(), id);
		
	}

	@Override
	public void saveProduct(Product p) {
		
		repository.save(p);
		
	}


}
