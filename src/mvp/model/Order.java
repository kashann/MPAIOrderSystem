package mvp.model;

import java.util.HashMap;

import mvp.model.strategy.PaymentStrategy;

public class Order {
	private User client;
	private HashMap<Product, Integer> orderList;
	
	public Order() {
		orderList = new HashMap<Product, Integer>();
	}
	
	public Order(User client, HashMap<Product, Integer> orderList) {
		super();
		this.client = client;
		this.orderList = orderList;
	}

	public User getClient() {
		return client;
	}

	public HashMap<Product, Integer> getOrderList() {
		return orderList;
	}

	public void processOrder(PaymentStrategy strategy) {
		strategy.getPaymentData();
	}
}
