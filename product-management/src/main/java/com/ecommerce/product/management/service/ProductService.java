package com.ecommerce.product.management.service;

import java.util.List;

import com.ecommerce.product.management.domain.Product;

public interface ProductService {

	void addProductsToOrder(List<Product> product);
	List<Product> getOrderProducts(Long orderId);
	
}
