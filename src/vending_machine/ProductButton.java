package vending_machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class ProductButton extends JButton{
	private ProduceDetails details;
	private JRadioButton enableButton;
	public ProductButton(String name, int cost) {
		super();
		this.setLayout(new BorderLayout());
		this.makeDetails(cost, name);
		this.makeRadiobutton(name);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f));
		this.setActionCommand(name + "," + cost);
		this.updateStatus(0);
	}
	
	private void makeDetails(int cost, String name) {
		this.details = new ProduceDetails(cost, name);
		this.add(this.details.getLabel(), BorderLayout.NORTH);
	}
	
	private void makeRadiobutton(String name) {
		enableButton = new JRadioButton("" + this.details.cost);
		enableButton.addActionListener(new radioRester());
		this.add(enableButton, BorderLayout.WEST);
	}
	
	public void updateStatus(int money) {
		boolean enable = this.detectEnable(money);
		this.details.updateEnable(enable) ;
		Boolean detecterBoolean = this.details.isEnable();
		this.enableButton.setSelected(detecterBoolean);
		this.setEnabled(detecterBoolean);
	}
	
	private Boolean detectEnable(int money) {
		Boolean detecter = (this.details.getCost() <= money);
		return detecter;
	}
	
	class ProduceDetails {
		private int cost;
		private boolean isEnable;
		private JLabel nameLabel;
		ProduceDetails (int cost , String name) {
			this.cost = cost;
			this.isEnable = false;
			nameLabel = new JLabel(name);
		}
		
		public JLabel getLabel() {
			return nameLabel;
		}
		
		public int getCost() {
			return this.cost;
		}
		
		public boolean isEnable() {
			return this.isEnable;
		}
		
		public void updateEnable(boolean enable) {
			this.isEnable = enable;
		}
	}
	
	class radioRester implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enableButton.setSelected(details.isEnable());
		}
	}
}
