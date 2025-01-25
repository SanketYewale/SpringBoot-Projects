package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Product;
import com.springboot.service.ProductManager;

@RestController
//@CrossOrigin("http://localhost:4200")
public class ProductController {
	@Autowired
	ProductManager manager;

	@GetMapping(value = "crud/product/{pid}", headers = "Accept=application/json")
	public ResponseEntity<Product> getProduct(@PathVariable int pid) {
		
		System.out.println("Get product Succesfully");
		
		return ResponseEntity.status(HttpStatus.FOUND).body(manager.getProduct(pid));
	}

	@GetMapping(value = "crud/products", headers = "Accept=application/json")
	public ResponseEntity<List<Product>> getAllProducts() {
		System.out.println("Get all Products  Succesfully");
		
		return ResponseEntity.status(HttpStatus.FOUND).body(manager.getAllProducts());
		
	}

	@DeleteMapping(value = "crud/delete/product/{pid}", headers = "Accept=application/json")
	public void deleteById(@PathVariable int pid) {
		manager.deleteById(pid);
		
		System.out.println("Product deleted Succesfully");
	}

	@PutMapping(value = "crud/update/product/{pid}", headers = "Accept=application/json")
	public void updateProduct(@RequestBody Product product, @PathVariable int pid) {
		manager.updateProduct(product, pid);
		
		System.out.println("Product Updated Succesfully");
	}

	@PostMapping(value = "crud/save/product", headers = "Accept=application/json")
	public void saveProduct(@RequestBody Product product) {

		manager.saveProduct(product);
		
		System.out.println("Product has been added Succesfully");
	}
}
