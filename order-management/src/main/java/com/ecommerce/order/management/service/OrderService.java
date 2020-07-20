package com.ecommerce.order.management.service;

import com.ecommerce.order.management.model.Order;

public interface OrderService {

	void createOrder(Order order);
	Order getOrder(Long orderId);
	
}
