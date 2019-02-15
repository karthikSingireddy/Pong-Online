package assets;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int paddleWidth = 20,
							paddleHeight = 60;
	public static final int scoreBoardWidth = 40,
							scoreBoardHeight = 30;
	
	public static BufferedImage bluePaddle, redPaddle, both, Ball, 
								endZones, scoreBoardBackground;
	
	public static BufferedImage spongebob;
	
	public static BufferedImage[] numbers;
	
	private final static int width = 12,
							 height = 16;
	
	public static void load() {
		SpriteSheet paddles = new SpriteSheet(ImageLoader.loadImage("/paddle/paddleV1.png"));
//		SpriteSheet ball = new SpriteSheet(ImageLoader.loadImage("/textures/paddle/ballV1"));
		endZones = ImageLoader.loadImage("/EndZonesV1.png");
		Ball = ImageLoader.loadImage("/paddle/ballV2.png");
		bluePaddle = paddles.crop(width, 0, width, height);
		redPaddle = paddles.crop(0, 0, width, height);
		spongebob = ImageLoader.loadImage("/memes/spongebob.png");
		Ball = ImageLoader.loadImage("/memes/rainbowball.png");
		scoreBoardBackground = ImageLoader.loadImage("/ScoreBoard/background.png");
		
	}
}