package main;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public static final int WIDTH = 600, HEIGHT = 650;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("The Cellular Automaton");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardLayout cl = new CardLayout();
		JPanel cardHolder = new JPanel(cl);

		cardHolder.add(new main.automaton.gameoflife.ContainerPanel(WIDTH, HEIGHT-50), "Game of Life");
		
		frame.add(cardHolder);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}
	
}
