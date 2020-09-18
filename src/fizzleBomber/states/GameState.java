package fizzleBomber.states;

import java.awt.Graphics;
import java.awt.Rectangle;

import fizzleBomber.Game;
import fizzleBomber.entities.creatures.Player;
import fizzleBomber.gfx.Assets;

public class GameState extends State {

	private Player player;
	
	public GameState(Game game){
		super(game);
		player= new Player(game,0,600);
	}
	 
	@Override
	public void tick() {
		player.tick();
		Rectangle  r = player.getBounds();
		Rectangle b = new Rectangle(1200,600,100,100);
		
	}

	@Override
	public void render(Graphics g ) {
		player.render(g);
	}

}
