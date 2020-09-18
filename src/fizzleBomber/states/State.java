package fizzleBomber.states;

import java.awt.Graphics;

import fizzleBomber.Game;

public abstract class  State {

	private static State currentState = null;
	
	//getter setter
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//Class
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
