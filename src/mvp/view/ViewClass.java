package mvp.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mvp.model.EBrand;
import mvp.model.EComputerType;

public class ViewClass implements IView {
	public JLabel brandLabel, typeLabel;
	public JComboBox<EBrand> brand;
	public JComboBox<EComputerType> type;
	public JTextField quantity;
	public JButton addProduct;
	public JTextArea order;
	public JScrollPane scroll;
	public JButton btnSubmit;
	
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
		//refresh ui after order sent
	}

	public void addProduct() {
		order.append(quantity.getText() + "X - " + brand.getSelectedItem() + " " + type.getSelectedItem() + "\n");
	}
}
