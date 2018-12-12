package main;

import javax.swing.JFrame;

import main.automaton.gameoflife.GameOfLifePanel;

public class Main {
	
	public static final int WIDTH = 600, HEIGHT = 600;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("The Cellular Automaton");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new GameOfLifePanel(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);
	}
	
}
