package main;

import javax.swing.JFrame;

public class Main {
	
	public static int WIDTH = 600;
	public static int HEIGHT = 600;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cellular Automata");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		
		frame.add(new CardHolder());
		
		frame.setVisible(true);
		
	}

}
