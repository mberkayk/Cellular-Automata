package main.automaton.gameoflife;

public class Cell {
	
	private int x, y;
	private boolean isActive;
	
	public Cell(int x, int y, boolean b) {
		this.x = x;
		this.y = y;
		this.setActive(b);
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
