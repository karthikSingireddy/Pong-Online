package mainScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import display.Display;

public class mainMenu {
	
	public Display display;
	
	public mainMenu(int width, int height) {
		this.display = new Display("Pong", width, height);
//		this.display = new JFrame();
//		this.display.setSize(width, height);
//		this.display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.display.setVisible(true);
		buttons();
	}
	
	private JButton b;
	
	public void buttons() {
		b = new JButton();
		b.setSize(50, 50);
		b.setLocation(50, 50);
		display.getFrame().getContentPane().add(b);
		display.getFrame().repaint();
		
//		display.getContentPane().add(b);
//		display.repaint();
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button pressed");
			}
		});
		display.getFrame().repaint();
	}
	public void startGame() {
		
	}
}
