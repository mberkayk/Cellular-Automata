package main.automaton.gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.Main;

public class GameOfLifePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	public GameOfLifePanel(int w, int h) {
		super();
		this.setPreferredSize(new Dimension(w, h));
		this.setSize(w, h);
		this.addMouseListener(this);
		init();
	}
	
	
	int cellSize = 30;
	
	int gridWidth = (int) Math.floor(Main.WIDTH / cellSize);
	int gridHeight =(int) Math.floor((Main.HEIGHT*3/4) / cellSize);
	
	byte[] cells = new byte[gridWidth*gridHeight];
	ArrayList<Iteration> iterations;
	
	int currentStep;
	
	
	public void init() {
		cellSize = 30;
		gridWidth = (int) Math.floor(Main.WIDTH / cellSize);
		gridHeight =(int) Math.floor(Main.HEIGHT / cellSize);
		cells = new byte[gridWidth*gridHeight];
		iterations = new ArrayList<Iteration>();
		iterations.add(new Iteration(0));
		currentStep = 0;
		iterations.get(currentStep).setActive(2);
		iterations.get(currentStep).setActive(21);
	}

	@Override
	public void paint(Graphics p) {
		Graphics2D g = (Graphics2D)p;
		
		//Background
		int bg = 70;
		g.setColor(new Color(bg, bg, bg));
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT*3/4);
		
		
		//Display Cells
		int ac = 125; // Color of the active cells
		g.setColor(new Color(ac, ac, ac));
		for(int i = 0; i < iterations.get(currentStep).size(); i++) {
			int cellX = (int)((iterations.get(currentStep).get(i) % gridWidth)*cellSize);
			int cellY = (int)(Math.floor(iterations.get(currentStep).get(i) / gridWidth)*cellSize);
			g.fillRect(cellX, cellY, cellSize, cellSize);
		}
		
		
		//Display Lines
		for(int i = cellSize; i < Main.WIDTH; i += cellSize) {
			g.setColor(Color.black);
			g.drawLine(i, 0, i, Main.HEIGHT*3/4);
		}
		for(int i = cellSize; i < Main.HEIGHT*3/4; i += cellSize) {
			g.setColor(Color.black);
			g.drawLine(0, i, Main.WIDTH, i);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouse clicked");
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	class Iteration {
		private int gen;
		private ArrayList<Integer> activeCells;
		
		public Iteration(int gen) {
			this.gen = gen;
			activeCells = new ArrayList<Integer>();
		}
		
		void setActive(int i) {
			activeCells.add(i);
		}
		
		int getGen() {
			return gen;
		}
		
		int get(int i) {
			return activeCells.get(i);
		}
		
		int size() {
			return activeCells.size();
		} 
	}
	
}
