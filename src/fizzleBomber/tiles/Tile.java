package fizzleBomber.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	protected BufferedImage texture;
	protected final int id;
	
	public static final int TILEWIDTH = 64,
							TILEHEIGHT = 64;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getId() {
		return id;
	}
	
}
