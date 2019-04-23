package main.automaton.langtons_ant;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class LangtonsAntPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	CellManager CM;
	
	public LangtonsAntPanel() {
		CM = new CellManager(50, 50);
		
	}
	
	@Override
	public void paint(Graphics g) {
		CM.display((Graphics2D)g, this.getWidth(), this.getHeight());
	}
	
	
}
