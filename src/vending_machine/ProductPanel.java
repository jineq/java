package vending_machine;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ProductPanel extends JPanel {
	ArrayList<ProductButton> buttons;
	
	public ProductPanel(ArrayList<String> produceNames, ArrayList<Integer> cost) {
		super();
		this.makeLayout();
		this.creatButtons(produceNames, cost);
	}
	
	private void creatButtons(ArrayList<String> produceNames,ArrayList<Integer> cost) {
		this.buttons = new ArrayList<ProductButton>();
		for (int i = 0; i < produceNames.size(); i++) {
			this.addButton(new ProductButton(produceNames.get(i), cost.get(i)));
		}
	}
	
	private void makeLayout() {
		GridLayout layout = new GridLayout(2,0);
		layout.setHgap(20);
		layout.setVgap(20);
		this.setLayout(layout);
	}
	
	public void addButton(ProductButton button) {
		this.buttons.add(button);
		this.add(button);
	}
	
	public void detectEnable(int money) {
		for (int i = 0; i < this.buttons.size(); i++) {
			ProductButton button = this.buttons.get(i);
			button.updateStatus(money);
		}
	}
	
	public void addFuction(ActionListener action) {
		for (int i = 0; i < this.buttons.size(); i++) {
			ProductButton button = this.buttons.get(i);
			button.addActionListener(action);
		}
	}
}
