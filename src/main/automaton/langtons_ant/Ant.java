package main.automaton.langtons_ant;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ant {
	
	private int x, y;
	private Direction dir;
	private BufferedImage image;
	
	public Ant(int x, int y) {
		this.setX(x);
		this.setY(y);
		setDir(Direction.NORTH);
		
		try {
			image = ImageIO.read(new File("assets/arrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	
	
}
