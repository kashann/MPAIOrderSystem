package mvp.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mvp.model.Angajat;

public class ViewClass implements IView {
	public JTextField tf1, tf2;
	public JButton btn;
	public JLabel label1;
	
	public ViewClass() {
		/*JFrame f = new JFrame("Date Angajat");
		f.getContentPane().setLayout(new FlowLayout());
		tf1 = new JTextField();
		tf2 = new JTextField("New Salary");
		btn = new JButton("Modify salary");
		tf1.setPreferredSize(new Dimension(60,20));
		tf1.setHorizontalAlignment(SwingConstants.CENTER);
		tf1.setEditable(false);
		tf2.setToolTipText("New Salary");
		label1 = new JLabel();
		f.getContentPane().add(label1);
		f.getContentPane().add(tf1);
		f.getContentPane().add(tf2);
		f.getContentPane().add(btn);
		
		f.setMinimumSize(new Dimension(350, 100));
		f.pack();
		f.setVisible(true);*/
	}

	@Override
	public void refreshUI(){
		//refresh ui after order sent
	}

}
