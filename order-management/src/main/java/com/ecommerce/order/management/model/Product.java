package com.ecommerce.order.management.model;

import lombok.Data;

@Data
public class Product {
	

	private Long productCode;

	private String productName;

	private Double quantity;

	private Long orderId;
		
}
