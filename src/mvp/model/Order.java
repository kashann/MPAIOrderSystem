package mvp.model;

import java.util.HashMap;

public class Order {
	private User client;
	private HashMap<Product, Integer> orderList;
	private EPayment paymentMethod; //transformam in interfata
	private EDelivery deliveryMethod; //transformam in interfata
	
	public Order() {
		orderList = new HashMap<Product, Integer>();
	}
	
	public Order(User client, HashMap<Product, Integer> orderList, EPayment paymentMethod, EDelivery deliveryMethod) {
		super();
		this.client = client;
		this.orderList = orderList;
		this.paymentMethod = paymentMethod;
		this.deliveryMethod = deliveryMethod;
	}

	public User getClient() {
		return client;
	}

	public HashMap<Product, Integer> getOrderList() {
		return orderList;
	}

	public EPayment getPaymentMethod() {
		return paymentMethod;
	}
	
	public EDelivery getDeliveryMethod() {
		return deliveryMethod;
	}

}
