package com.ecommerce.order.management.validation;

import com.ecommerce.order.management.model.Order;

public interface Validator {
	
	void validate(Order o) ;

}
