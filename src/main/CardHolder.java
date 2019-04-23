package main;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardHolder extends JPanel {
	private static final long serialVersionUID = 1L;
	
	CardLayout cl;
	
	public CardHolder() {
		cl = new CardLayout();
		
		this.setLayout(cl);
		
		this.add(new MenuPanel(this), "Menu");
		this.add(new main.automaton.gameoflife.ContainerPanel(Main.WIDTH, Main.HEIGHT), "Game of Life");
		this.add(new main.automaton.langtons_ant.LangtonsAntPanel(), "Langton's Ant");
	}
	
	public void actionPerformed(String command) {
		System.out.println(command);
		
		cl.show(this, command);
		
	}
	
}
