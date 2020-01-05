package mvp.model.order_builder;

import java.util.ArrayList;

import mvp.model.Order;
import mvp.model.OrderItem;
import mvp.model.Product;
import mvp.model.User;
import mvp.model.strategy.PaymentStrategy;

public class OrderBuilder {
	private User client;
	private ArrayList<OrderItem> orderList;
	private PaymentStrategy paymentStrategy;
	
	public OrderBuilder() {
		this.orderList = new ArrayList<OrderItem>();
	}
	
	public OrderBuilder from(User client) {
		this.client = client;
		return this;
	}	
	
	public OrderBuilder addProduct(Product product, int quantity) {
		this.orderList.add(new OrderItem(product, quantity));
		return this;
	}
	
	public OrderBuilder paymentAs(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
		return this;
	}
	
	public Order getOrder() {
		Order order = new Order(client, orderList, paymentStrategy);
		return order;
	}
}