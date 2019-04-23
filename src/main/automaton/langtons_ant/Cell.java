package main.automaton.langtons_ant;

public class Cell {
	
	private int x,y;
	private boolean isSet;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.isSet = false;
	}
	
	public void set(boolean b) {
		isSet = b;
	}
	
	public boolean isSet() {
		return isSet;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
