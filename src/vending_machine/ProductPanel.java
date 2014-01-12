package vending_machine;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

public class ProductPanel extends JPanel {
	ArrayList<ProductButton> buttons;
	
	public ProductPanel(ArrayList<Product> produce) {
		super();
		this.buttons = new ArrayList<ProductButton>();
		this.makeLayout();
		this.initButtons(produce);
	}
	
	private void initButtons(ArrayList<Product> produce) {
		Iterator<Product> iterator = produce.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			String  name    = product.getName();
			int     cost    = product.getCost();
			
			ProductButton button  = new ProductButton(name, cost);
			this.buttons.add(button);
			this.add(button);
		}
	}
	
	private void makeLayout() {
		GridLayout layout = new GridLayout(2,0);
		layout.setHgap(20);
		layout.setVgap(20);
		this.setLayout(layout);
	}
	
	public void detectEnable(int money) {
		Iterator<ProductButton> iterator = this.buttons.iterator();
		while (iterator.hasNext()) {
			ProductButton button = iterator.next();
			button.updateStatus(money);
		}
	}
	
	public void addFuction(ActionListener action) {
		Iterator<ProductButton> iterator = this.buttons.iterator();
		while (iterator.hasNext()) {
			ProductButton button = iterator.next();
			button.addActionListener(action);
		}
	}
}
