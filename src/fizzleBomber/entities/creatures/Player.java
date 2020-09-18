package fizzleBomber.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import fizzleBomber.Game;
import fizzleBomber.gfx.Assets;
import fizzleBomber.input.MyMouseListener;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this    .game = game;
	}
	
	@Override
	public void tick() {
		double a = getInput();
		if(a != 0){
			move(getInput());
		}
	}
	
	//Get Input From Mouse
	public double getInput() {
		double x= game.getMouseListener().x;
		double y =700- game.getMouseListener().y;
		double theta = Math.atan(x/y);
		return theta;
	}
	
	@Override
	public void render(Graphics g) {
		if(x==0 && y==600) {
			g.drawImage(Assets.blust,1200,600,100,100,null);
			game.getMouseListener().leftPressed = false;
			
		}
		else{
			g.drawImage(Assets.bomb, (int) x , (int) y ,width, height, null);
		}
	}
}
