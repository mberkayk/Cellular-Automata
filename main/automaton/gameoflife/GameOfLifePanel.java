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
	int offset; // offset of displaying how many steps before the current step 
	
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
		offset = 0;
		
		renderImage();
	}
	
	public void renderImage() {
		Graphics2D g = image.createGraphics();
		
		//Display Cells
		for(int i = 0; i < iterations.get(iterations.size()-1 - offset).size(); i++) {
			
			Cell c = iterations.get(iterations.size()-1 - offset).get(i);
			
			g.setColor(new Color(100, 100, 100));
			if(c.isActive()) {
				g.setColor(new Color(125, 125, 125));
			}
			g.fillRect(c.getX()*cellSize, c.getY()*cellSize, cellSize, cellSize);
			g.setColor(Color.black);
			g.drawRect(c.getX()*cellSize, c.getY()*cellSize, cellSize, cellSize);
			
			g.setColor(Color.black);
			int nc = iterations.get(iterations.size()-1).getActiveNeighbourCount(i);
			if(nc != 0)
			g.drawString(String.valueOf(nc), c.getX()*cellSize + cellSize/2, c.getY()*cellSize + cellSize/2);
			
		}
		
		//Bakcground for info display and Buttons
		g.setColor(Color.white);
		g.fillRect(0, 541, 600, 60);
		
		//Display info
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		g.drawString("Current Step: " + (currentStep - offset), 0, 570);

		//Previous Button
		g.setColor(Color.black);
		g.fillRect(250, 550, 100, 40);
		g.setColor(Color.white);
		g.drawString("Previous", 270, 575);
		
		//Next Button
		g.setColor(Color.black);
		g.fillRect(370, 550, 100, 40);
		g.setColor(Color.white);
		g.drawString("Next", 405, 575);
		
		//Reset Button
		g.setColor(Color.black);
		g.fillRect(500, 550, 70, 40);
		g.setColor(Color.white);
		g.drawString("Reset", 517, 575);
		
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
				Cell c = iterations.get(iterations.size()-1).get(gridWidth * (MY/cellSize) +(MX/cellSize));
				//Switch its state
				c.setActive(!c.isActive());
				renderImage();
			
			}else { //If some button is clicked
				
				//Previous Button
				if(MX < 350 && MX > 250 && MY < 590 && MY > 550) {
					if(offset < 9 && currentStep - offset > 0) {
						offset++;
					}
				}else if(MX < 470 && MX > 370 && MY < 590 && MY > 550) { //Next Button
					if(offset == 0) {
						if(iterations.size() == 10) {
	
							iterations.add(this.iterations.get(iterations.size()-1).createIteration());
							iterations.remove(0);
							currentStep++;
						}else {
							iterations.add(this.iterations.get(iterations.size()-1).createIteration());
							currentStep++;
						}
					}else {
						offset--;
					}
				}else if(MX < 570 && MX > 500 && MY < 590 && MY > 550) { // RESET Button
				
					currentStep = 0;
					offset = 0;
					
					iterations.removeAll(iterations);
					iterations.add(new Iteration(0, gridWidth, gridHeight));
					
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
