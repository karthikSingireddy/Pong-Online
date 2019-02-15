package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import assets.Assets;
import paddle.Paddle;

public class Ball {
	
	private double xSpeed;
	private double ySpeed;
	
	private int MaxSpeedX, MaxSpeedY;
	
	private int diam;
	private Game game;
	public Ball(Game game, int diam) {
		this.game = game;
		this.MaxSpeedX = 4;
		this.MaxSpeedY = 4;
//		this.xSpeed = (r.nextInt(5)/10.0) + .5;
//		this.ySpeed = (r.nextInt(5)/10.0) + .5;
		this.xSpeed = 100;
		this.ySpeed = 100;
		x = game.width/2;
		y = game.height/2;
		this.diam = diam;
	}
	public void startMoving(int xSpeed) {
		this.xSpeed = xSpeed;
		
	}
	private int x = 5, y = 5;
	
	
	public void tick() {
		if(true) {
			x+= xSpeed;
		}
		if(true) {
			y-=ySpeed;
		}
		this.collisions2();
	}
	
	private void collisions1() {
		
		int centerY = this.y + diam/2;
		
		if(((this.x + this.diam == game.getRedPaddle().getX()) && 
			(centerY > game.getRedPaddle().getY())
			&&
			centerY < game.getRedPaddle().getY() + Assets.paddleHeight
				) || (this.x + diam == game.width || this.x == 0) || 
				
				(
						this.x == game.getBluPaddle().getX() + Assets.paddleWidth
						&&
						((centerY > game.getBluPaddle().getY())
								&&
						centerY < game.getBluPaddle().getY() + Assets.paddleHeight)
						)
				)
			{
			xSpeed = -xSpeed;
			ySpeed = -ySpeed;
			if(ySpeed == 0) {
				ySpeed = 0.5;
			}
//			ySpeed = xSpeed;
//			System.out.println(ySpeed);
		}
		
		if(this.y == 0 || this.y + this.diam == game.height) {
			this.ySpeed *= -1;
//			this.xSpeed *= .5;
			this.xSpeed *= -1;
		}
		
//		System.out.println("Ball x is: " + this.x + "\n"
//				+ " Ball y = " + this.y + "\n"
//						+ " redPaddle y = " + game.getRedPaddle().getY() + "\n"
//								+ " redPaddle x = " + game.getRedPaddle().getX());
	}
	
	private void collisions2() {
		if(this.horizontalBorders()) {
			ySpeed = -ySpeed;
		}
		if(this.redScore() || this.blueScore()) {
			if(this.redScore()) game.getScoreBoard().increaseRed();
			if(this.blueScore()) game.getScoreBoard().increaseBlue();
			this.x = game.width/2;
			this.y = game.height/2;
//			xSpeed = new java.util.Random().nextInt(this.MaxSpeedX);
//			ySpeed = new java.util.Random().nextInt(this.MaxSpeedY);
			Random r = new Random();
			xSpeed = r.nextInt(4)+2;
			ySpeed = r.nextInt(4)+2;
			
		}
		if(this.bluPaddleCollision(game.getBluPaddle()) || this.redPaddleCollision(game.getRedPaddle())) {
			if(this.bluPaddleCollision(game.getBluPaddle())) {
				if(game.getKeyManager().s) {
					
				}
				x = game.getBluPaddle().x + Assets.paddleWidth;
			}
			else if(this.redPaddleCollision(game.getRedPaddle())) {
				x = game.getRedPaddle().x - diam;
			}
			xSpeed = -xSpeed;
		}
	}
	
	private boolean horizontalBorders() {
		if(this.y <= 0 || this.y + this.diam >= game.height) 
			return true;
		return false;
	}
	private boolean redScore() {
		if(this.x <= 0) 
			return true;
		return false;
	}
	private boolean blueScore() {
		if(this.x + this.diam >= game.width)
			return true;
		return false;
	}
	
	private boolean redPaddleCollision(Paddle p) {
		int centerY = this.y + diam/2;
		if ((this.x + this.diam >= p.getXBorder()) && 
			(centerY >= p.getY() - (Assets.paddleHeight/3))
			&&
			centerY <= p.getY() + (Assets.paddleHeight*1.1)
		) {
			return true;
		}
		return false;
	}
	private boolean bluPaddleCollision(Paddle p) {
		int centerY = this.y + diam/2;
		if ((this.x + this.diam <= p.getXBorder()) && 
			(centerY >= p.getY() - (Assets.paddleHeight/3))
			&&
			centerY <= p.getY() + (Assets.paddleHeight*1.1)
		) {
			return true;
		}
		return false;
	}
	
	public void render(Graphics g) {
		
//		g.drawImage(Assets.Ball, x, y, 50, 50, null);
//		g.setColor(Color.BLACK);
		g.setColor(new Color(42, 13, 197));
//		g.setColor(new Color(0, 0, 0, 0)); // R, G, B, OPACITY(0 being transparent)
		g.fillOval(this.x, this.y, this.diam, this.diam);
//		System.out.println("ball rendered");
 
//		g.drawImage(Assets.Ball, this.x, this.y, this.diam, this.diam, null);
		}
}