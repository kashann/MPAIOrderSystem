package mvp.model;

import java.util.ArrayList;

import mvp.model.strategy.PaymentStrategy;

public class Order {
	private User client;
	private ArrayList<OrderItem> orderList;
	
	public Order() {
		orderList = new ArrayList<OrderItem>();
	}
	
	public Order(User client, ArrayList<OrderItem> orderList) {
		super();
		this.client = client;
		this.orderList = orderList;
	}

	public User getClient() {
		return client;
	}

	public ArrayList<OrderItem> getOrderList() {
		return orderList;
	}

	public void processOrder(PaymentStrategy strategy) {
		strategy.getPaymentData();
	}
}
