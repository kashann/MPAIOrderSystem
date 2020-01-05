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

	public void setClient(User client) {
		this.client = client;
	}

	public HashMap<Product, Integer> getOrderList() {
		return orderList;
	}

	public void setOrderList(HashMap<Product, Integer> orderList) {
		this.orderList = orderList;
	}

	public EPayment getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(EPayment paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public EDelivery getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(EDelivery deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	
	public void addProduct(Product product, int quantity) {
		orderList.put(product, quantity);
	}
}
