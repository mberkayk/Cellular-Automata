package main.automaton.gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameOfLifePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	int cellSize;
	
	int gridWidth, gridHeight;
	
	ArrayList<Iteration> iterations;
	
	int currentStep;
	
	private BufferedImage image;
	
	public GameOfLifePanel(int w, int h) {
		super();
		this.setPreferredSize(new Dimension(w, h));
		this.setSize(w, h);
		this.addMouseListener(this);
		image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		//Set the size of the step 0
		gridWidth = 20;
		gridHeight = 18;
		
		cellSize = getWidth() / gridWidth;
		
		iterations = new ArrayList<Iteration>();
		iterations.add(new Iteration(0, gridWidth, gridHeight));
		
		currentStep = 0;
		
		renderImage();
	}
	
	public void renderImage() {
		Graphics2D g = image.createGraphics();
		
		//Display Cells
		for(int i = 0; i < iterations.get(currentStep % 10).size(); i++) {
			Cell c = iterations.get(currentStep % 10).get(i);
			
			g.setColor(new Color(100, 100, 100));
			if(c.isActive()) {
				g.setColor(new Color(125, 125, 125));
			}
			g.fillRect(c.getX()*cellSize, c.getY()*cellSize, cellSize, cellSize);
			g.setColor(Color.black);
			g.drawRect(c.getX()*cellSize, c.getY()*cellSize, cellSize, cellSize);
			
		}
		
		g.setColor(Color.white);
		g.fillRect(0, 540, 600, 60);
		
		//Display info
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		g.drawString("Current Step: " + currentStep, 0, 570);
		
		//Next Button
		g.setColor(Color.black);
		g.fillRect(370, 550, 100, 40);
		g.setColor(Color.white);
		g.drawString("NEXT", 400, 570);
		
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//If left Mouse Button has been clicked
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			int MX = e.getX();
			int MY = e.getY();
			
			//If one of the cells has been clicked
			if(MY < cellSize*gridHeight) {
				
				//Get the clicked cell
				Cell c = iterations.get(currentStep % 10).get(gridWidth * (MY/cellSize) +(MX/cellSize));
				//Switch its state
				c.setActive(!c.isActive());
				renderImage();
			
			}else { //If some button is clicked
				
				//NEXT Button
				if(MX < 470 && MX > 370 && MY < 590 && MY > 550) {
					if(iterations.size() == 10) {

						iterations.add((currentStep+1) % 10, this.iterations.get(currentStep % 10).createIteration());
						iterations.remove((currentStep+1) % 10);
						currentStep++;
					}else {
						iterations.add(this.iterations.get(currentStep % 10).createIteration());
						currentStep++;
					}
				}
				
				renderImage();
				
			}
		}
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
	
}
