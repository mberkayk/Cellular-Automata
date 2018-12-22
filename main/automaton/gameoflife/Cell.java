package main.automaton.gameoflife;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	
	private int x, y;
	private boolean isActive;
	
	public Cell(int x, int y, boolean b) {
		this.x = x;
		this.y = y;
		this.setActive(b);
	}
	
	public void display(Graphics g) {
		
		
	
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	public boolean isActive() {
		return isActive;
	}
	

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
