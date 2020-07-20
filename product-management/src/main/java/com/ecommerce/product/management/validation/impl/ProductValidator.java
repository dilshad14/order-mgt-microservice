package com.ecommerce.product.management.validation.impl;

import org.springframework.stereotype.Component;

import com.ecommerce.product.management.domain.Product;
import com.ecommerce.product.management.exception.ValidationException;
import com.ecommerce.product.management.util.Constants;
import com.ecommerce.product.management.validation.Validator;

@Component
public class ProductValidator implements Validator {

	@Override
	public void validate(Product p) {
		if (p.getOrderId() == null || p.getOrderId() < 1) {
			throw new ValidationException(Constants.Validation.ORDER_ID_INVALID);
		}

		if (p.getProductCode() == null || p.getOrderId() < 1) {
			throw new ValidationException(Constants.Validation.PRODUCT_ID_INVALID);
		}

		if (p.getProductName() == null || p.getProductName().isBlank()) {
			throw new ValidationException(Constants.Validation.PRODUCT_NAME_INVALID);
		}

		if (p.getQuantity() == null || p.getQuantity() <= 0) {
			throw new ValidationException(Constants.Validation.PRODUCT_QTY_INVALID);
		}

	}

}
