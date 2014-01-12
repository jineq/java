package vending_machine;

import java.awt.event.ActionListener;

public class InputSet {
	private InputMoneyPanel inPanel;
	private ChangeButton changeButton;	
	
	public InputSet(ActionListener moneyUpdate, ActionListener changeButton) {
		this.inPanel      = new InputMoneyPanel();
		this.changeButton = new ChangeButton();
		this.inPanel.addActionListener(moneyUpdate);
		this.changeButton.addActionListener(changeButton);
	}
	
	public InputMoneyPanel getPanel() {
		return this.inPanel;
	}
	
	public ChangeButton getButton() {
		return this.changeButton;
	}
	
	public int getMoney() {
		int money = 0;
		try{
			money = Integer.parseInt(this.inPanel.getText());
		} catch ( Exception e2) {
		}
		return money;
	}
}
