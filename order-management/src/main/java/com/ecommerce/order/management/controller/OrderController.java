package com.ecommerce.order.management.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.management.model.Order;
import com.ecommerce.order.management.model.Product;
import com.ecommerce.order.management.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/create")
	public HttpEntity<Object> createOrder(@RequestBody Order order) {
		
		orderService.createOrder(order);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	

	@GetMapping("/{orderId}")
	public HttpEntity<Object> OrderDetail(@PathVariable("orderId") Long orderId) {
		Order ord =  orderService.getOrder(orderId);
		return new ResponseEntity<>(ord,HttpStatus.OK);

	}
	


	}
	

