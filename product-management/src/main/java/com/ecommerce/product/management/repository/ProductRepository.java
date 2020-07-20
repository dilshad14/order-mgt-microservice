package com.ecommerce.product.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.product.management.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByOrderId(Long orderId);
	
	

}
