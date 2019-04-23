package main.automaton.langtons_ant;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class CellManager {
	
	private Cell[][] cells;
	private int gridWidth, gridHeight;
	private Ant ant;
	
	public CellManager(int gridWidth, int gridHeight) {
		
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		
		cells = new Cell[gridWidth][gridHeight];
		for(int y = 0; y < gridHeight; y++) {
			
		
			for(int x = 0; x < gridWidth; x++) {
				
				cells[x][y] = new Cell(x, y); 
				
			}
		}
		
		ant = new Ant(gridWidth/2, gridHeight/2);
		
	}
	
	public void display(Graphics2D g, int screenWidth, int screenHeight) {
		
		int cellWidth = screenWidth / gridWidth;
		int cellHeight = screenHeight / gridHeight;
		
		for(Cell[] cells1: cells) {
			
			for(Cell c: cells1) {
				
				if(c.isSet()) {
					g.setColor(new Color(230, 230, 230));
				}else {
					g.setColor(new Color(30, 30, 30));
				}
				
				g.fillRect(c.getX() * cellWidth, c.getY() * cellHeight, cellWidth, cellHeight);
				
				g.setStroke(new BasicStroke(1));
				g.setColor(new Color(0,0,0));
				g.drawRect(c.getX() * cellWidth, c.getY() * cellHeight, cellWidth, cellHeight);
				
			}
			
		}
		
		g.drawImage(ant.getImage(), ant.getX() * cellWidth, ant.getY() * cellHeight, cellWidth, cellHeight, null);
		
	}

}
