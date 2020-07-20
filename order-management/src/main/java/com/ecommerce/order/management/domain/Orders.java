package com.ecommerce.order.management.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="ORDERS")
public class Orders {
	
	@Id
	@GeneratedValue()
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="ORDER_DATE")
	private LocalDate orderDate;
	
	@Column(name="SHIPPING_ADDRESS")
	private String shippingAddress;
	
	@Column(name="TOTAL")
	private Double total;
		
}
