package mvp.model.order_builder;

import java.util.HashMap;

import mvp.model.EDelivery;
import mvp.model.EPayment;
import mvp.model.Order;
import mvp.model.Product;
import mvp.model.User;

public class OrderBuilder {
	private User client;
	private HashMap<Product, Integer> orderList;
	private EPayment paymentMethod; //transformam in interfata
	private EDelivery deliveryMethod; //transformam in interfata
	
	public OrderBuilder() {
		this.orderList = new HashMap<Product, Integer>();
	}
	
	public OrderBuilder from(User client) {
		this.client = client;
		return this;
	}
	
	public OrderBuilder addProduct(Product product, int quantity) {
		this.orderList.put(product,  quantity);
		return this;
	}
	
	public OrderBuilder withPayment(EPayment paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}
	
	public OrderBuilder withDelivery(EDelivery deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
		return this;
	}
	
	public Order getOrder() {
		Order order = new Order(client, orderList);
		return order;
	}
}