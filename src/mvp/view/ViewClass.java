package mvp.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mvp.model.EBrand;

public class ViewClass implements IView {
	public JComboBox<EBrand> brand;
	public JComboBox<String> specs;
	public JTextField quantity;
	public JButton addProduct;
	public JButton btnSubmit;
	
	public ViewClass() {
		JFrame f = new JFrame("Online Order System");
		f.getContentPane().setLayout(new GridLayout(1, 5));
		f.setPreferredSize(new Dimension(500, 200));
		brand = new JComboBox<EBrand>();
		specs = new JComboBox<String>();
		quantity = new JTextField();
		addProduct = new JButton("Add Product");
		btnSubmit = new JButton("Submit Order");
		f.getContentPane().add(brand);
		f.getContentPane().add(specs);
		f.getContentPane().add(quantity);
		f.getContentPane().add(addProduct);
		f.getContentPane().add(btnSubmit);
		
		f.setMinimumSize(new Dimension(350, 100));
		f.pack();
		f.setVisible(true);
	}

	@Override
	public void refreshUI(){
		//refresh ui after order sent
	}

}
