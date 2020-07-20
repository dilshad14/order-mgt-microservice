package com.ecommerce.order.management.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.order.management.model.Product;

@FeignClient(value = "productClient", url = "${client.product.url}")
public interface ProductClient {


	@RequestMapping(method = RequestMethod.GET, value = "/orderproducts", produces = "application/json")
	List<Product> getProductsOfOrder(@RequestParam("orderid") Long orderId);

	@RequestMapping(method = RequestMethod.POST, value = "/addtoorder", produces = "application/json")
	void createProductsForOrder(@RequestBody List<Product> lstProd);
}
