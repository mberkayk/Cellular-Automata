package main.automaton.gameoflife;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ContainerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	GameOfLifePanel gp;
	UIPanel uip;
	
	public ContainerPanel(int w, int h){
		
		gp = new GameOfLifePanel(w, h);
		uip = new UIPanel(this);
		
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		this.add(gp, BorderLayout.CENTER);
		this.add(uip, BorderLayout.NORTH);
		
		
	}

}
