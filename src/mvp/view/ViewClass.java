package mvp.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import mvp.model.CreditCard;
import mvp.model.EBrand;
import mvp.model.EComputerType;
import mvp.model.EDelivery;
import mvp.model.EPayment;
import mvp.model.Order;
import mvp.model.OrderItem;
import mvp.model.Product;
import mvp.model.User;
import mvp.model.order_builder.OrderBuilder;
import mvp.model.strategy.BankTransferStrategy;
import mvp.model.strategy.CashOnDeliveryPayment;
import mvp.model.strategy.CreditCardPayment;
import mvp.model.strategy.PaymentStrategy;

public class ViewClass {
	public JLabel brandLabel, typeLabel, quantityLabel;
	public JComboBox<EBrand> brand;
	public JComboBox<EComputerType> type;
	public JFormattedTextField quantity;
	public JButton addProduct, btnSubmit, sendOrder;
	public JTextArea order;
	public JScrollPane scroll;
	public JComboBox<EPayment> payment;
	public JComboBox<EDelivery> delivery;
	public JComboBox<String> address;
	public JTextField addressField;
	public JFrame f, checkout;
	public ArrayList<OrderItem> orderList = new ArrayList<OrderItem>();
	public User user;
	public int id;
	private NumberFormat format;
	private PaymentStrategy paymentStrategy;
	
	public ViewClass() {
		user = new User("John", "Doe", "johndoe@gmail.com", 721234567, "Piata Romana Nr. 6, Room 1234, Bucharest", "Str. Caderea Bastiliei Nr. 2-10, Room 0123, Bucharest",
				new CreditCard(1234567890123456l, "John Doe", 10, 22, 987));
		JPanel productArea = new JPanel();
		brandLabel = new JLabel("Brand");
		brand = new JComboBox<EBrand>(EBrand.values());
		typeLabel = new JLabel("Type");
		type = new JComboBox<EComputerType>(EComputerType.values());
		quantityLabel = new JLabel("X");
		format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(1);
	    formatter.setMaximum(99999);
	    formatter.setAllowsInvalid(false);	
	    formatter.setOverwriteMode(true);
	    formatter.setCommitsOnValidEdit(true);
		quantity = new JFormattedTextField(formatter);
		quantity.setPreferredSize(new Dimension(50, 25));
		quantity.setText("1");
		addProduct = new JButton("Add Product");
		productArea.add(brandLabel);
		productArea.add(brand);
		productArea.add(typeLabel);
		productArea.add(type);
		productArea.add(quantityLabel);
		productArea.add(quantity);
		productArea.add(addProduct);

		JPanel orderSummary = new JPanel();
		order = new JTextArea();
		order.setEditable(false);
		scroll = new JScrollPane(order);
		scroll.setPreferredSize(new Dimension(200, 120));
		orderSummary.add(scroll, BorderLayout.PAGE_START);
		
		JPanel submitArea = new JPanel();
		payment = new JComboBox<EPayment>(EPayment.values());
		delivery = new JComboBox<EDelivery>(EDelivery.values());
		btnSubmit = new JButton("Submit Order");
		submitArea.add(payment);
		submitArea.add(delivery);
		submitArea.add(btnSubmit);
		
		f = new JFrame("Online Order System");
		f.getContentPane().setLayout(new BorderLayout());
		f.setPreferredSize(new Dimension(500, 250));
		f.add(productArea, BorderLayout.NORTH);
		f.add(orderSummary, BorderLayout.CENTER);
		f.add(submitArea, BorderLayout.SOUTH);
		f.setMinimumSize(new Dimension(350, 100));
		f.pack();
		f.setVisible(true);
	}
	
	public void submit() {
		if(orderList.isEmpty())
			return;
		id = (int)(Math.random() * (100000 - 12345)) + 12345;
		
		JPanel paymentPanel = new JPanel();
		paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));
        if(payment.getSelectedItem() == EPayment.CASH_ON_DELIVERY) {
        	paymentStrategy = new CashOnDeliveryPayment();
    		JLabel cod = new JLabel("You will pay with CASH or CARD upon delivery.");
        	cod.setAlignmentX(Component.CENTER_ALIGNMENT);
        	paymentPanel.add(cod);
        }
        else if(payment.getSelectedItem() == EPayment.CREDIT_CARD) {
        	paymentStrategy = new CreditCardPayment();
        	JPanel cardPanel1 = new JPanel();
        	cardPanel1.setLayout(new BoxLayout(cardPanel1, BoxLayout.X_AXIS));
        	JLabel cardNumber = new JLabel("Card Number    ");
        	NumberFormatter cardNumberFormatter = new NumberFormatter(format);
        	cardNumberFormatter.setValueClass(Long.class);
        	cardNumberFormatter.setMinimum(1000000000000000l);
        	cardNumberFormatter.setMaximum(9999999999999999l);
        	cardNumberFormatter.setAllowsInvalid(false);
        	cardNumberFormatter.setCommitsOnValidEdit(true);
        	JFormattedTextField numberField = new JFormattedTextField(cardNumberFormatter);
        	numberField.setText(user.getCard().getNumber() + "");
        	cardPanel1.add(cardNumber);
        	cardPanel1.add(numberField);
        	
        	JPanel cardPanel2 = new JPanel();
        	cardPanel2.setLayout(new BoxLayout(cardPanel2, BoxLayout.X_AXIS));
        	JLabel cardHolder = new JLabel("Name of Account Holder    ");
        	JTextField nameField = new JTextField(user.getCard().getHolder());
        	cardPanel2.add(cardHolder);
        	cardPanel2.add(nameField);
        	
        	JPanel cardPanel3 = new JPanel();
        	cardPanel3.setLayout(new BoxLayout(cardPanel3, BoxLayout.X_AXIS));
        	JLabel cardExpiry = new JLabel("Expiry Date Month/Year    ");
        	String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        	JComboBox<String> month = new JComboBox<String>(months);
        	month.setSelectedIndex(user.getCard().getExpiryMonth() - 1);
        	int yearsToShow = 20;
        	ArrayList<String> years = new ArrayList<String>();
        	int currentYear = Calendar.getInstance().get(Calendar.YEAR)%100;
        	for(int i = currentYear; i <= currentYear + yearsToShow; i++)
        		years.add(i + "");
        	String[] yearsStrings = new String[years.size()];
        	JComboBox<String> year = new JComboBox<String>(years.toArray(yearsStrings));
        	for(int i = 0; i < yearsStrings.length; i++) {
        		if(Integer.parseInt(yearsStrings[i]) == user.getCard().getExpiryYear())
        			year.setSelectedIndex(i);        		
        	}
        	cardPanel3.add(cardExpiry);
        	cardPanel3.add(month);
        	cardPanel3.add(year);
        	
        	JPanel cardPanel4 = new JPanel();
        	cardPanel4.setLayout(new BoxLayout(cardPanel4, BoxLayout.X_AXIS));
        	JLabel cardCVV = new JLabel("Security Code (CVV/CVC)    ");
        	NumberFormatter cvvFormatter = new NumberFormatter(format);
        	cvvFormatter.setValueClass(Integer.class);
        	cvvFormatter.setMinimum(100);
        	cvvFormatter.setMaximum(999);
        	cvvFormatter.setAllowsInvalid(false);
        	cvvFormatter.setCommitsOnValidEdit(true);
        	JFormattedTextField cvvField = new JFormattedTextField(cvvFormatter);
        	cvvField.setText(user.getCard().getCvv() + "");
        	cardPanel4.add(cardCVV);
        	cardPanel4.add(cvvField);
        	
        	paymentPanel.add(cardPanel1);
        	paymentPanel.add(cardPanel2);
        	paymentPanel.add(cardPanel3);
        	paymentPanel.add(cardPanel4);
        }
    	else if(payment.getSelectedItem() == EPayment.BANK_TRANSFER) {
    		paymentStrategy = new BankTransferStrategy();
    		JLabel paymentInstruction = new JLabel("Please make the transfer to the following bank account:");
    		JLabel companyInfo = new JLabel("SC Gang of Four SRL (RO12345678 - J40/12345/2020)");
    		JLabel hqInfo = new JLabel("HQ: Calea Dorobanți 15-17, București 010552");
    		JLabel iban = new JLabel("IBAN: RO81 RZBR 0000 0612 3456 7890");
    		JLabel details = new JLabel("Specify details \"for order " + id + "\"");
    		paymentInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);
    		companyInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
    		hqInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
    		iban.setAlignmentX(Component.CENTER_ALIGNMENT);
    		details.setAlignmentX(Component.CENTER_ALIGNMENT);
        	paymentPanel.add(paymentInstruction);
        	paymentPanel.add(companyInfo);
        	paymentPanel.add(hqInfo);
        	paymentPanel.add(iban);
        	paymentPanel.add(details);
    	}
        
		JPanel deliveryPanel = new JPanel();
		deliveryPanel.setLayout(new BoxLayout(deliveryPanel, BoxLayout.Y_AXIS));
        if(delivery.getSelectedItem() == EDelivery.HOME_DELIVERY) {
        	JPanel addressPanel = new JPanel();
        	addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.X_AXIS));
        	String[] addresses = {"Delivery Address", "Billing Address", "Other Address"};
        	address = new JComboBox<String>(addresses);
        	addressField = new JTextField(user.getDeliveryAddress());
  		  	addressField.setEditable(false);
        	address.addActionListener (new ActionListener () {
        	    public void actionPerformed(ActionEvent e) {
        	    	switch(address.getSelectedIndex()) {
        	    	  case 0:
        	    		  addressField.setText(user.getDeliveryAddress());
        	    		  addressField.setEditable(false);
        	    		  break;
        	    	  case 1:
        	    		  addressField.setText(user.getBillingAddress());
        	    		  addressField.setEditable(false);
        	    		  break;
        	    	  case 2:
        	    		  addressField.setText("");
        	    		  addressField.setEditable(true);
        	    		  break;
        	    	}
        	    }
        	});        	
        	addressPanel.add(address);
        	addressPanel.add(addressField);
        	deliveryPanel.add(addressPanel);
        }        	
    	else if(delivery.getSelectedItem() == EDelivery.STORE_PICKUP) {
    		JLabel pickup1 = new JLabel("Please pickup your order withing 2 working days from our store");
    		JLabel pickup2 = new JLabel("in Calea Dorobanți 15-17, București 010552.");
    		JLabel pickup3 = new JLabel("Your order ID is " + id);
    		pickup1.setAlignmentX(Component.CENTER_ALIGNMENT);
    		pickup2.setAlignmentX(Component.CENTER_ALIGNMENT);
    		pickup3.setAlignmentX(Component.CENTER_ALIGNMENT);
    		deliveryPanel.add(pickup1);
    		deliveryPanel.add(pickup2);
    		deliveryPanel.add(pickup3);
    	}
        
        JPanel sendOrderPanel = new JPanel();
		sendOrder = new JButton("Send Order");
		sendOrder.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendOrder();
			}
		});
		sendOrderPanel.add(sendOrder);
		
		checkout = new JFrame("Order Checkout");
		checkout.getContentPane().setLayout(new BorderLayout());
		checkout.setPreferredSize(new Dimension(500, 300));
		checkout.add(paymentPanel, BorderLayout.NORTH);
		checkout.add(new JLabel());
		checkout.add(deliveryPanel, BorderLayout.CENTER);
		checkout.add(sendOrderPanel, BorderLayout.SOUTH);
		checkout.setMinimumSize(new Dimension(350, 100));
		checkout.pack();
		checkout.setVisible(true);
	}
	
	public void sendOrder() {
		try {
			paymentStrategy.getPaymentData(user);
			Thread.sleep(500);
			Order sentOrder = new OrderBuilder().from(user).setOrderList(orderList).setOrderId(id).paymentAs(paymentStrategy).getOrder();
			paymentStrategy.pay(sentOrder.getOrderValue());
			Thread.sleep(1000);
			System.out.println(sentOrder.toString());
			checkout.dispose();
			orderList.clear();
			order.setText("");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
