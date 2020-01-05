package mvp.model;

import java.util.ArrayList;

import mvp.model.strategy.PaymentStrategy;

public class Order {
	private User client;
	private ArrayList<OrderItem> orderList;
	private PaymentStrategy paymentStrategy;
	
	public Order() {
		orderList = new ArrayList<OrderItem>();
	}
	
	public Order(User client, ArrayList<OrderItem> orderList, PaymentStrategy paymentStrategy) {
		super();
		this.client = client;
		this.orderList = orderList;
		this.paymentStrategy = paymentStrategy;
	}

	public User getClient() {
		return client;
	}

	public ArrayList<OrderItem> getOrderList() {
		return orderList;
	}

	public PaymentStrategy getPaymentStrategy() {
		return paymentStrategy;
	}
//	public void processOrder(PaymentStrategy strategy) {
//		strategy.getPaymentData();
//	}
}
