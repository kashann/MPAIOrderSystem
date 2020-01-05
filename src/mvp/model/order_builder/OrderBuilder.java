package mvp.model.order_builder;

import java.util.HashMap;

import mvp.model.Order;
import mvp.model.Product;
import mvp.model.User;

public class OrderBuilder {
	private User client;
	private HashMap<Product, Integer> orderList;
	
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
	
	public Order getOrder() {
		Order order = new Order(client, orderList);
		return order;
	}
}