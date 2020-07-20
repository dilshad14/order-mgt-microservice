package com.ecommerce.order.management.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class Order {

	private Long orderId;

	private String customerName;

	private LocalDate orderDate;

	private String shippingAddress;

	private Double total;

	private List<Product> products;

}
