package mvp.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvp.model.Angajat;
import mvp.model.Order;
import mvp.view.ViewClass;

public class PresenterClass {
	public ViewClass view;
	public Order order;
	
	public PresenterClass(ViewClass view) {
		this.view = view;
		btnAddListner();
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
	
	public void btnAddListner() {
		view.btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//angajat.setSalary(Integer.parseInt(view.tf2.getText()));
				//view.refreshUI(angajat);
			}
		});
	}
}
