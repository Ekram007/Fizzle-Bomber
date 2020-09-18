package fizzleBomber.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener extends MouseAdapter {
	
	 public  int x;
	 public  int y;
	 public boolean leftPressed , rightpressed;
	 
	 public void tick() {
		
	 }

	@Override
	public void mouseClicked(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased() {
		
	}
	
}
