package main.automaton.gameoflife;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	GameOfLifePanel gp;
	
	private JButton preBtn, nextBtn, resetBtn;
	private JLabel crntStepLbl;
	
	public UIPanel(ContainerPanel p) {
		gp = p.gp;
		
		this.setLayout(new FlowLayout());
		
		preBtn = new JButton("Previous");
		nextBtn = new JButton("Next");
		resetBtn = new JButton("Reset");
		
		preBtn.setActionCommand("preBtn");
		nextBtn.setActionCommand("nextBtn");
		resetBtn.setActionCommand("resetBtn");
		
		preBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		
		this.add(preBtn);
		this.add(nextBtn);
		this.add(resetBtn);
		
		crntStepLbl = new JLabel("Current Step: " + (gp.currentStep - gp.offset));
		this.add(crntStepLbl, FlowLayout.LEFT);
		
		this.setVisible(true);
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command == "preBtn") {
			
			if(gp.offset < 9 && gp.currentStep - gp.offset > 0) {
				gp.offset++;
			}
			
		}else if(command == "nextBtn") {
			
			if(gp.offset == 0) {
				if(gp.iterations.size() == 10) {

					gp.iterations.add(gp.iterations.get(gp.iterations.size()-1).createIteration());
					gp.iterations.remove(0);
					gp.currentStep++;
				}else {
					gp.iterations.add(this.gp.iterations.get(gp.iterations.size()-1).createIteration());
					gp.currentStep++;
				}
			}else {
				gp.offset--;
			}
			
		}else if(command == "resetBtn") {
			
			gp.currentStep = 0;
			gp.offset = 0;
			
			gp.iterations.removeAll(gp.iterations);
			gp.iterations.add(new Iteration(0, gp.gridWidth, gp.gridHeight));
			
		}
		
		crntStepLbl.setText("Current Step: " + (gp.currentStep - gp.offset));
		gp.renderImage();
	}
	
}
