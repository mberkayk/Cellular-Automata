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
		
		this.setLayout(new BorderLayout());
		this.add(gp, BorderLayout.CENTER);
		this.add(uip, BorderLayout.SOUTH);
		
		
	}

}
