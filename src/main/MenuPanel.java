package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private CardHolder cardHolder;
	
	private JButton GOLBtn; // Game of life button
	private JButton langtonsBtn; // Langton's Ant
	
	public MenuPanel(CardHolder cardHolder) {
		
		this.cardHolder = cardHolder;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		GOLBtn = new JButton("Game of Life");
		langtonsBtn = new JButton("Langton's Ant");
		
		GOLBtn.setActionCommand("Game of Life");
		langtonsBtn.setActionCommand("Langton's Ant");
		
		GOLBtn.addActionListener(this);
		langtonsBtn.addActionListener(this);
		
		this.add(GOLBtn);
		this.add(langtonsBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cardHolder.actionPerformed(e.getActionCommand());
	}
}
