package vending_machine;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyLabel extends JPanel {
	private int money;
	private TextLabel textLabel;
	
	public MoneyLabel() {
		super();
		new MoneyLabel(10000,new Color(30, 30, 30),new Color(200,200,200),"お金");
	}
	
	public MoneyLabel(int money,Color bgcolor,Color textColor,String message) {
		super();
		setLayout(new GridBagLayout());
		this.money=money;
		this.textLabel = new TextLabel(textColor, message);
		this.setBackground(bgcolor);
		add(textLabel);
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void addMoney(int money) {
		this.money += money;
		this.textLabel.drawMessage(this.money);
	}
	
	public void subMoney(int money) {
		this.money -= money;
		this.textLabel.drawMessage(this.money);
	}
	
	public void clearMoney() {
		this.money=0;
		this.textLabel.drawMessage(0);
	}
	
	class TextLabel extends JLabel {
		private String message;
		
		public TextLabel(Color textColor,String message) {
			super();
			this.message = message;
			this.setText(message);
			this.setForeground(textColor);
		}
		
		public void drawMessage(int money) {
			this.setText(this.message+" : "+money);
		}
	}
}
