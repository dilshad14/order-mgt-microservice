package com.ecommerce.order.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.order.management.domain.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
	
	Orders findByOrderId(Long orderId);

}
