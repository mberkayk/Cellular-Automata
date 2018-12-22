package main.automaton.gameoflife;

import java.util.ArrayList;

public class Iteration {

	private int gen;
	private int gridWidth, gridHeight;
	
	private ArrayList<Cell> cells;
	
	public Iteration(int gen, int gridWidth, int gridHeight) {
		
		this.gen = gen;
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		cells = new ArrayList<Cell>();
		
		//Add the Cells to the iteration
		for(int i = 0; i < gridHeight; i++) {
					
			for(int j = 0; j < gridWidth; j++) {
						
			this.add(new Cell(j, i, false));
		
			}
		}
	}
	
	public int getGen() {
		return gen;
	}

	public void add(Cell c) {
		cells.add(c);
	}
	
	public Cell get(int i) {
		return cells.get(i);
	}
	
	public int size() {
		return cells.size();
	}
	
	public Iteration createIteration() {
		
		Iteration next = new Iteration(this.getGen()+1, this.gridWidth, this.gridHeight);
				
		//Activate or deactivate the cells in the next iteration based on this iteration
		for(int i = 0; i < cells.size(); i++) {
			if(this.getActiveNeighbourCount(i) == 3) {
				next.get(i).setActive(true);
			}else if(this.getActiveNeighbourCount(i) == 2) {
				next.get(i).setActive(this.get(i).isActive());
			}
		}
		
		return next;
	}
	
	int getActiveNeighbourCount(int i) {
		//Eight Special cases
		if(this.get(i).getY() == 0 && this.get(i).getX() == 0) {
			
			int result = 0;
			//Check the three neighbours
			if(this.get(i+1).isActive()) {
				result++;
			}if(this.get(i + gridWidth + 1).isActive()) {
				result++;
			}if(this.get(i + gridWidth).isActive()) {
				result++;
			}
			
			return result;
			
		}else if(this.get(i).getY() == 0 && this.get(i).getX() == gridWidth - 1){
			int result = 0;
			//Check the three neighbours
			if(this.get(i-1).isActive()) {
				result++;
			}if(this.get(i + gridWidth - 1).isActive()) {
				result++;
			}if(this.get(i + gridWidth).isActive()) {
				result++;
			}
			
			return result;
			
		}else if(this.get(i).getY() == gridHeight - 1 && this.get(i).getX() == 0) {
			
			int result = 0;
			//Check the three neighbours
			if(this.get(i+1).isActive()) {
				result++;
			}if(this.get(i - gridWidth + 1).isActive()) {
				result++;
			}if(this.get(i - gridWidth).isActive()) {
				result++;
			}
			
			return result;
			
		}else if(this.get(i).getY() == gridHeight - 1 && this.get(i).getX() == gridWidth - 1) {
			
			int result = 0;
			//Check the three neighbours
			if(this.get(i-1).isActive()) {
				result++;
			}if(this.get(i - gridWidth - 1).isActive()) {
				result++;
			}if(this.get(i - gridWidth).isActive()) {
				result++;
			}
			
			return result;
		
		}else if(this.get(i).getY() == 0) {
			
			int result = 0;
			
			if(this.get(i-1).isActive()) {
				result++;
			}if(this.get(i+1).isActive()) {
				result++;
			}if(this.get(i + gridWidth - 1).isActive()) {
				result++;
			}if(this.get(i + gridWidth).isActive()) {
				result++;
			}if(this.get(i + gridWidth + 1).isActive()) {
				result++;
			}
			
			return result;
			
		}else if(this.get(i).getY() == gridHeight - 1) {
			
			int result = 0;
			
			if(this.get(i-1).isActive()) {
				result++;
			}if(this.get(i+1).isActive()) {
				result++;
			}if(this.get(i - gridWidth - 1).isActive()) {
				result++;
			}if(this.get(i - gridWidth).isActive()) {
				result++;
			}if(this.get(i - gridWidth + 1).isActive()) {
				result++;
			}
			
			return result;
			
		}else if(this.get(i).getX() == 0) {
			
			int result = 0;
			
			if(this.get(i-gridWidth).isActive()) {
				result++;
			}if(this.get(i - gridWidth +1).isActive()) {
				result++;
			}if(this.get(i + 1).isActive()) {
				result++;
			}if(this.get(i + gridWidth + 1).isActive()) {
				result++;
			}if(this.get(i + gridWidth).isActive()) {
				result++;
			}
			
			return result;
			
		}else if(this.get(i).getX() == gridWidth - 1) {
			
			int result = 0;
			
			if(this.get(i-gridWidth).isActive()) {
				result++;
			}if(this.get(i - gridWidth - 1).isActive()) {
				result++;
			}if(this.get(i - 1).isActive()) {
				result++;
			}if(this.get(i + gridWidth - 1).isActive()) {
				result++;
			}if(this.get(i + gridWidth).isActive()) {
				result++;
			}
			
			return result;
			
		}else {
			int result = 0;
			
			for(int j = -1; j <= 1; j++) {
				for(int k = -1; k <= 1; k++) {
					if(k == 0 && j == 0) continue;
					
					if(this.get(i + j + k*gridWidth).isActive()) {
						result++;
					}
					
				}
			}
			
			return result;
		}
		
	}

}