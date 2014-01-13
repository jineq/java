package vending_machine;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class VendinMachine extends JFrame {
	MoneyPanel moneyPanel;
	Result result;
	ProductPanel productPanel;
	
	public static void main(String[] args) {
		new VendinMachine();
	}
	
	public VendinMachine() {
		super();
		this.createTop();
		this.createMiddle();
		this.createBottom();
		this.setLocation(40, 40);
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void createTop() {
		String[]  nameArray = {"りんごジュース", "玉子ジュース", "hogeジュース", "kanpeジュース", "jineqジュース", "bananaジュース"};
		Integer[] costArray = {100, 200, 300, 300, 300, 300};
		
		ArrayList<Product> productList = new ArrayList<Product>();
		for (int i = 0; i < nameArray.length; i++) {
			Product product = new Product(costArray[i], nameArray[i]);
			productList.add(product);
		}
		this.productPanel = new ProductPanel(productList);
		this.productPanel.addFuction(new ProduceButtonPushed());
		this.add(this.productPanel, BorderLayout.NORTH);
	}
	
	private void createMiddle() {
		this.moneyPanel = new MoneyPanel(new MoneyUpdate(), new ChangeEvent());
		this.add(moneyPanel , BorderLayout.CENTER);
	}
	
	private void createBottom() {
		this.result = new Result();
		
		JScrollPane pane = new JScrollPane(this.result);
		this.add(pane, BorderLayout.SOUTH);
	}
	
	class MoneyUpdate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int money = moneyPanel.getMoney();				
			this.updateMoney(money);
			productPanel.detectEnable(moneyPanel.amountMoney());
		}
		
		private void updateMoney(int money) {
			if (money <= moneyPanel.pocketMoney()) {
				this.addMoney(money);
				return;
			}
			moneyPanel.lackMoney();
			result.append("\nお金が足りっていません");
		}
		
		private void addMoney(int money) {
			moneyPanel.insertMoney(money);
			if (money < 0){
				return;
			}
			String resultMessageString = "\n " + money + "円のお金を入れました 現在、入金したお金は　:" + moneyPanel.amountMoney();
			result.append(resultMessageString);
		}
	}
	
	class ChangeEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			result.append("\n " + moneyPanel.amountMoney() + "円のお釣りを取りました");
			moneyPanel.changePushed();
			productPanel.detectEnable(0);
		}
	}
	
	class ProduceButtonPushed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String    string = e.getActionCommand();
			String[] command = string.split(",");
			int        money = Integer.parseInt(command[1]);
			moneyPanel.boughtProduct(money);
			result.append("\n" + command[0] + " を買いました 値段は : " + command[1] + "円です");
			productPanel.detectEnable(moneyPanel.amountMoney());
		}
	}
}