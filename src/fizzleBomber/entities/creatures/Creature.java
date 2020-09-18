package fizzleBomber.entities.creatures;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fizzleBomber.Game;
import fizzleBomber.display.Display;
import fizzleBomber.entities.Entity;
import fizzleBomber.gfx.Assets;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 10.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 100,
							  DEFAULT_CREATURE_HEIGHT = 80;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove; 
	
	public Creature(float x, float y, int width, int height) {
		super(x, y,width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	//Moveing the bomb
	public void move(double theta) {
		Rectangle  r = getBounds();
		Rectangle r1 = new Rectangle(1200,600,100,100);
		if(r.intersects(r1)) {                                         //IF BOMB AND HOME COLLIDE
			
			x=0; 
			y=600;
			
			Game.Score = Game.Score + 1;
			
			
		}
		else if(y>600) {                                               //IF BOMB AND HOME DOESNT COLLIDE
			x=0;
			y=600;
			JOptionPane.showMessageDialog(null, "Your Score = " + Game.Score ,"Game Over",JOptionPane.ERROR_MESSAGE );
			Game.Score = 0;
		}
		else {                                                         //WHEN BOMB IS MOVING THROUGH AIR
			x=x+2;
			
		    double tanTheta = Math.tan(90-theta);
		    double cosTheta = Math.cos(90-theta);
		    double v= 110;
		    double g= 9.8;
		    double a = x*tanTheta;
		    double b = g*x*x;
		    double c = 2*v*v*cosTheta*cosTheta;
		    
		    
			double y1 = 600 - a + b/c;
			y=(int)y1;
		}
		
	}

	//Getters Setters
	
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
