package vending_machine;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MoneyPanel extends JPanel{
	private MoneyStatus status;
	private InputSet inputSet;
	
	public MoneyPanel(ActionListener moneyUpdate, ActionListener changeButton) {
		super();
		this.makeLayout();
		this.createComponents(moneyUpdate,changeButton);
		this.insertComponent();
	}
	
	private void createComponents(ActionListener moneyUpdate, ActionListener changeButton) {
		this.status = new MoneyStatus("財布のお金", "入金したお金");
		this.inputSet = new InputSet(moneyUpdate, changeButton);
	}
	
	private void insertComponent() {
		this.add(this.status.getPocket());
		this.add(this.inputSet.getButton());
		this.add(this.inputSet.getPanel());
		this.add(this.status.getLabel());
	}
	
	public int getMoney() {
		return this.inputSet.getMoney();
	}
	
	public int pocketMoney() {
		MoneyLabel pocketLabel = this.status.getPocket();
		return pocketLabel.getMoney();
	}
	
	public int amountMoney() {
		MoneyLabel moneyLabel = this.status.getLabel();
		return moneyLabel.getMoney();
	}
	
	public void insertMoney(int money) {
		status.insertMoney(money);
	}
	
	private void makeLayout() {
		GridLayout layout = new GridLayout(2,2);
		layout.setHgap(20);
		layout.setVgap(20);
		this.setLayout(layout);
	}
	
	public void lackMoney() {
		InputMoneyPanel panel = this.inputSet.getPanel();
		panel.setText("お金が足りっていません");
	}
	
	public void boughtProduct(int cost) {
		MoneyLabel label = this.status.getLabel();
		label.subMoney(cost);
	}
	
	public void changePushed() {
		this.status.change();
	}
}
