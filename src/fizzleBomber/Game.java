package fizzleBomber;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

import fizzleBomber.display.Display;
import fizzleBomber.gfx.Assets;
import fizzleBomber.input.KeyManager;
import fizzleBomber.input.MyMouseListener;
import fizzleBomber.states.GameState;
import fizzleBomber.states.MenuState;
import fizzleBomber.states.State;

public class Game implements Runnable {
	
	private Display display;
	
	public String title;
	public int width,height;
	
	public Thread thread;
	
	//Graphics
	private BufferStrategy bs;
	private Graphics g;
	
	public static boolean running = false;
	
	//States
	private State gameState;
	private State menuState;
	
	public JLabel score = new JLabel();
	public static int Score = 0;
	
	//Input
	private KeyManager keyManager;
	private MyMouseListener mouseListener;
	
	public Game(String title, int width, int height) {
		this.width= width;
		this.height = height;
		this.title= title;
		
		mouseListener = new MyMouseListener();
		
	}
	
	//Initialization
	private void init() {
		
		display = new Display(title,width,height);
		
		display.getFrame().addMouseListener( mouseListener );
		display.getFrame().addMouseMotionListener(mouseListener);
		display.getCanvas().addMouseListener(mouseListener);
		display.getCanvas().addMouseMotionListener(mouseListener);
		
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	
	}

	//Updating 
	private void tick() {
		
		mouseListener.tick();
		
		if(State.getState()!= null)
			State.getState().tick();
	}
	
	//Drawing
	private void render() {
		bs= display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return ;
		}
		g= bs.getDrawGraphics();
		
		//Clear Screen
		
		g.clearRect(0,0, width, height);
		
		
		//Draw Start
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 1400, 800);
		g.setColor(Color.BLACK);

		Font f= new Font(Font.SERIF, Font.BOLD, 30);
		g.setFont(f);
		g.drawString("Your Score : "+Integer.toString(Score), 30 , 40);
		
		g.drawImage(Assets.jongi,1200,600,100,100,null);
		g.drawImage(Assets.bomb, 0, 600,100,80, null);
		
		if(State.getState()!= null) {
			State.getState().render(g);
		}
		
		
		//Draw finsh
		
		bs.show();
		g.dispose();
		
	}
	
	//Game Loop
	
	public void run() {
		
		
		while(running) {
			System.out.println(mouseListener.leftPressed);
			
			if(mouseListener.leftPressed==true) {
				display.play.setVisible(false);
				tick();
				render();
				
				
			}
			else{
				continue;
			}
			
		}
		
	}
	
	//Action Listeners
	public MyMouseListener getMouseListener() {
		return mouseListener;
	}
	
	
	//Game start
	public synchronized void start() {
		thread = new Thread(this);
		running = true;
		init();
		thread.start();
		
		
	}
	
	//Game Stop
	public synchronized void stop() {
		running = false;
		//thread.stop();
	}
}
