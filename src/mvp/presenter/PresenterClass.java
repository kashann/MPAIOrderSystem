package mvp.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import mvp.model.Angajat;
import mvp.model.EBrand;
import mvp.model.EComputerType;
import mvp.model.EPayment;
import mvp.model.Order;
import mvp.model.OrderItem;
import mvp.model.Product;
import mvp.view.ViewClass;

public class PresenterClass {
	public ViewClass view;
	public Order order;
	
	public PresenterClass(ViewClass view) {
		this.view = view;
		addActionListners();
		order = new Order();
	}	

	public ViewClass getView() {
		return view;
	}

	public void setView(ViewClass view) {
		this.view = view;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void addActionListners() {
		view.addProduct.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.quantity.getText().isEmpty())
					return;
				view.order.append(view.quantity.getText() + "X - " + view.brand.getSelectedItem() + " " + view.type.getSelectedItem() + "\n");
				Product product = new Product(EBrand.valueOf(view.brand.getSelectedItem().toString()), 
						EComputerType.valueOf(view.type.getSelectedItem().toString()), 10);
				OrderItem item = new OrderItem(product , Integer.parseInt(view.quantity.getText()));
				view.orderList.add(item);
				view.quantity.setText("1");
			}
		});
		view.btnSubmit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.submit();
			}
		});
	}
}
