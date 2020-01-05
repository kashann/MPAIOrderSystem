package mvp.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mvp.model.EBrand;
import mvp.model.EComputerType;
import mvp.model.EDelivery;
import mvp.model.EPayment;
import mvp.model.OrderItem;
import mvp.model.Product;

public class ViewClass implements IView {
	public JLabel brandLabel, typeLabel;
	public JComboBox<EBrand> brand;
	public JComboBox<EComputerType> type;
	public JTextField quantity;
	public JButton addProduct;
	public JTextArea order;
	public JScrollPane scroll;
	public JButton btnSubmit;
	public JComboBox<EPayment> payment;
	public JComboBox<EDelivery> delivery;
	public JButton sendOrder;
	private ArrayList<OrderItem> orderList;
	
	public ViewClass() {
		JPanel productArea = new JPanel();
		brandLabel = new JLabel("Brand");
		brand = new JComboBox<EBrand>(EBrand.values());
		typeLabel = new JLabel("Type");
		type = new JComboBox<EComputerType>(EComputerType.values());
		quantity = new JTextField();
		quantity.setPreferredSize(new Dimension(50, 25));
		//quantity. //numeric validation
		addProduct = new JButton("Add Product");
		productArea.add(brandLabel);
		productArea.add(brand);
		productArea.add(typeLabel);
		productArea.add(type);
		productArea.add(quantity);
		productArea.add(addProduct);

		JPanel orderSummary = new JPanel();
		order = new JTextArea(); //size
		order.setEditable(false);
		//scroll = new JScrollPane(order);
		orderSummary.add(order, BorderLayout.PAGE_START);
		
		JPanel submitArea = new JPanel();
		btnSubmit = new JButton("Submit Order");
		submitArea.add(btnSubmit);
		
		JFrame f = new JFrame("Online Order System");
		f.getContentPane().setLayout(new BorderLayout());
		f.setPreferredSize(new Dimension(600, 200));
		f.add(productArea, BorderLayout.NORTH);
		f.add(orderSummary, BorderLayout.CENTER);
		f.add(submitArea, BorderLayout.SOUTH);
		f.setMinimumSize(new Dimension(350, 100));
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void refreshUI() {
		quantity.setText("");
	}

	public void addProduct() {
		order.append(quantity.getText() + "X - " + brand.getSelectedItem() + " " + type.getSelectedItem() + "\n");
		Product product = new Product(EBrand.valueOf(brand.getSelectedItem().toString()), 
				EComputerType.valueOf(type.getSelectedItem().toString()), 10);
		OrderItem item = new OrderItem(product , Integer.parseInt(quantity.getText()));
		orderList.add(item); //null pointer exception?????????????
	}
	
	public void submit() {
		JFrame checkout = new JFrame("Order Checkout");
		checkout.getContentPane().setLayout(new BorderLayout());
		checkout.setPreferredSize(new Dimension(600, 200));
		payment = new JComboBox<EPayment>(EPayment.values());
		delivery = new JComboBox<EDelivery>(EDelivery.values());
		sendOrder = new JButton("Send Order");
		sendOrder.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendOrder();
			}
		});
		
		checkout.getContentPane().add(payment);
		checkout.getContentPane().add(delivery);
		checkout.getContentPane().add(sendOrder);
		checkout.setMinimumSize(new Dimension(350, 100));
		checkout.pack();
		checkout.setVisible(true);
	}
	
	public void sendOrder() {
		System.out.println("s a trimis comanda " + orderList.toString());
	}
}
