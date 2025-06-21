package com.springboot.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var orderService = context.getBean(OrderService.class);
//		Below code is not needed as we are handling DI using spring beans
//		var orderService = new OrderService();
//		orderService.setPaymentService(new PayPalPaymentService());
		orderService.placeOrder();
	}

}
