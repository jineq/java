package vending_machine;

import javax.swing.JTextArea;

public class Result extends JTextArea{
	public Result() {
		super(10, 10);
		this.setLineWrap(true);
		this.setText("Welcome to Vending Machine");
		this.setEditable(false);
	}
}
