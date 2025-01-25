/**
 * This is JPA Repository
 */
package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Product;

/**
 * 
 */

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findById(int id);
	
	Product save(Product p);
	
	List<Product> findAll();
	
	void deleteById(Integer id);
	
	@Modifying
	@Query("update Product p set p.name = :name, p.price = :price, p.qty=:qty where p.id = :id")
	void update(@Param("name") String name,@Param("price") int price,@Param("qty") int qty,@Param("id")int id);
}
