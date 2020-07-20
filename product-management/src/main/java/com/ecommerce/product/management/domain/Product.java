package com.ecommerce.product.management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="PRODUCT")
public class Product {
	
	@Id
	@Column(name="ID")
	@GeneratedValue()
	private Long id;
	
	@Column(name="PRODUCT_CODE")
	private Long productCode;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="QUANTITY")
	private Double quantity;
	
	@Column(name="ORDER_ID")
	private Long orderId;
		
}
