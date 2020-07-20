package com.ecommerce.order.management.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.order.management.client.ProductClient;
import com.ecommerce.order.management.model.Order;
import com.ecommerce.order.management.model.Product;
import com.ecommerce.order.management.repository.OrderRepository;
import com.ecommerce.order.management.service.OrderService;
import com.ecommerce.order.management.validation.Validator;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductClient prodClient;

	@Autowired
	Validator validator;

	@Override
	public void createOrder(Order orderM) {
		validator.validate(orderM);

		Long orderId = 0L;
		try {

			orderId = saveOrder(orderM);
			saveProducts(orderM, orderId);

		} catch (Exception e) {
			// log the error

			// in case of error while saving products, then rollback order
			if (orderId != 0L) {
				orderRepository.deleteById(orderId);
			}
			throw new RuntimeException(e.getMessage());
		}

	}

	@Transactional
	private Long saveOrder(Order orderM) {
		com.ecommerce.order.management.domain.Orders orderE = new com.ecommerce.order.management.domain.Orders();
		BeanUtils.copyProperties(orderM, orderE);
		com.ecommerce.order.management.domain.Orders ord = orderRepository.save(orderE);
		return ord.getOrderId();

	}

	private void saveProducts(Order orderM, Long orderId) {
		List<Product> lstProd = orderM.getProducts();

		lstProd.forEach(p -> p.setOrderId(orderId));

		prodClient.createProductsForOrder(lstProd);

	}

	@Override
	public Order getOrder(Long orderId) {

		com.ecommerce.order.management.domain.Orders orderE = orderRepository.findByOrderId(orderId);
		Order orderM = new Order();
		BeanUtils.copyProperties(orderE, orderM);// call client to get list of products

		List<Product> lstProd = prodClient.getProductsOfOrder(orderId);
		orderM.setProducts(lstProd);
		return orderM;

	}

}
