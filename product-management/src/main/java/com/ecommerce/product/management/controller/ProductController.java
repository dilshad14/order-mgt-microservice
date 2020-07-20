package com.ecommerce.product.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.management.domain.Product;
import com.ecommerce.product.management.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService prodService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/addtoorder")
	public HttpEntity<Object> addProductsToOrder(@RequestBody List<Product> lstProd) {
		prodService.addProductsToOrder(lstProd);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/orderproducts")
	public HttpEntity<Object> getOrderProducts(@RequestParam("orderid") Long orderId) {
		List<Product> products = prodService.getOrderProducts(orderId);
		return new ResponseEntity<>(products, HttpStatus.OK);

	}

}
