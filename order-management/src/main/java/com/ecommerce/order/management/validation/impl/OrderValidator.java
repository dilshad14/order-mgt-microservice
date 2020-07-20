package com.ecommerce.order.management.validation.impl;

import org.springframework.stereotype.Component;

import com.ecommerce.order.management.exception.ValidationException;
import com.ecommerce.order.management.model.Order;
import com.ecommerce.order.management.util.Constants;
import com.ecommerce.order.management.validation.Validator;

@Component
public class OrderValidator implements Validator {

	@Override
	public void validate(Order o) {

		if (o.getCustomerName() == null || o.getCustomerName().isBlank()) {
			throw new ValidationException(Constants.Validation.CUSTOMER_NAME_INVALID);
		}

		if (o.getOrderDate() == null) {
			throw new ValidationException(Constants.Validation.ORDER_DATE_INVALID);
		}

		if (o.getShippingAddress() == null || o.getShippingAddress().isBlank()) {
			throw new ValidationException(Constants.Validation.ORDER_SHIPPING_ADDRESS_INVALID);
		}

	}

}
