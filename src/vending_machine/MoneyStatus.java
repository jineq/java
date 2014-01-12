package vending_machine;

import java.awt.Color;

public class MoneyStatus {
	private MoneyLabel pocketMoney,moneyLabel;
	
	public MoneyStatus(String pocket, String money) {
		this.pocketMoney = new MoneyLabel(10000,new Color(1.0f,1.0f,1.0f),new Color(0, 0, 0),pocket);
		this.moneyLabel = new MoneyLabel(0,new Color(0.2f,0.2f,0.2f),new Color(0.0f,1.0f,0.0f),money);
	}
	
	public MoneyLabel getPocket() {
		return this.pocketMoney;
	}
	
	public MoneyLabel getLabel() {
		return this.moneyLabel;
	}
	
	public void change() {
		pocketMoney.addMoney(moneyLabel.getMoney());
		moneyLabel.clearMoney();
	}
	
	public void insertMoney(int money) {
		this.pocketMoney.subMoney(money);
		moneyLabel.addMoney(money);
	}

}
