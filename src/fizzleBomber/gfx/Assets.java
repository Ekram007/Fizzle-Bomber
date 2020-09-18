package fizzleBomber.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width =50, height = 50;
	
	public static BufferedImage ball,img1,img2,img3,bomb,jongi,blust;
	
	//Loading all images
	
	public static void init() {
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/rong-tuli.jpg"));
		
		bomb= ImageLoader.loadImage("/textures/BOMB11.jpg");
		jongi = ImageLoader.loadImage("/textures/jongi.png"); 
		blust = ImageLoader.loadImage("/textures/blust.jpg");
	}
	
}
