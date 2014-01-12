package swingexam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Swingtest extends JFrame {
	public static void main(String[] args) {
	}
	Swingtest(){
		JButton b = new JButton("Close");
		b.setLocation(30, 30);
		b.setSize(100,100);
		b.addActionListener(new CloseButton());
		this.add(b);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	
	class CloseButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
}
