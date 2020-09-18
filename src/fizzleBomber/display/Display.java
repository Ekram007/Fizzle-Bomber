package fizzleBomber.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fizzleBomber.gfx.Assets;



public class Display {
	
	private JFrame frame;
	
	private Canvas canvas;
	private JLabel fizzlebomber;
	private JLabel score;
	public JLabel play;
	private JPanel panel;
	public static int Score = 0;
	 
	private BufferStrategy bs;
	private Graphics g;
	
	
	private String title;
	private int width,height;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	//Creating Display
	
	private void createDisplay() {
		frame = new JFrame(title);
		score = new JLabel("high score "+ Integer.toString(Score));
		score.setBounds(300, 230,10 , 10);
		//frame.add(score);
		
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocation(0, 0);
		frame.setVisible(true);
		
		fizzlebomber = new JLabel("FIZZLE BOMBER");
		fizzlebomber.setBounds(500, 0,330,50);
		
		Font font = new Font("",Font.BOLD,40);
		fizzlebomber.setFont(font);
		fizzlebomber.setForeground(Color.BLUE);
		
		
		play = new JLabel ("START");	
		play.setBounds(600,300,200,50);
		
		Font font1 = new Font("Roman new times",Font.BOLD,20);
		play.setFont(font1);
		play.setForeground(Color.RED);
		play.setBackground(Color.BLUE);
		
		frame.add(play);
		frame.add(fizzlebomber);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		

		
		
		frame.add(canvas);
		frame.pack();
		

		
	}
	
	//Getter Setter
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}


