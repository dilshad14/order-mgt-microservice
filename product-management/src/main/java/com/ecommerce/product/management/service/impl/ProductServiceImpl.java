package com.ecommerce.product.management.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.management.domain.Product;
import com.ecommerce.product.management.exception.NoDataFoundException;
import com.ecommerce.product.management.repository.ProductRepository;
import com.ecommerce.product.management.service.ProductService;
import com.ecommerce.product.management.util.Constants;
import com.ecommerce.product.management.validation.Validator;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	Validator validator;

	@Override
	@Transactional
	public void addProductsToOrder(List<Product> lstProds) {

		lstProds.forEach(e -> {
			validator.validate(e);
			productRepository.save(e);
		});
	}

	@Override
	public List<Product> getOrderProducts(Long orderId) {
		List<Product> lstProd =  productRepository.findByOrderId(orderId);
		if (lstProd.isEmpty()) {
			throw new NoDataFoundException(Constants.NO_DATA_FOUND);
		}
		return lstProd;
	}

}
