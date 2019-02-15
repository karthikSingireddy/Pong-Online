package paddle;

import java.awt.Graphics;

import assets.Assets;
import game.Game;
import game.KeyManager;
import sockets.OnlineTest;

public class RedPaddle extends Paddle {
	private KeyManager keymanager;
//	private static final int x = 550;
	public RedPaddle(Game game) {
		super(game);
		this.keymanager = game.getKeyManager();
		super.x = (int) (game.width *0.95);
		super.red = true;
	}
	

	@Override
	public int getXBorder() {
		return super.x;
	}
	@Override
	public int getFarXBorder() {
		return super.x + Assets.paddleWidth;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if((keymanager.arrowUp || game.getSt().up) && super.y != 0) {
			y-= speed;
		}
		if((keymanager.arrowDown || game.getSt().down) && super.y + Assets.paddleHeight != game.height) {
			y += speed;
		}
		if(keymanager.plus)
			y-= 1;
		if(keymanager.minus) y+=1;
//		y = game.height/2;
		
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.redPaddle, super.x, super.y, Assets.paddleWidth, Assets.paddleHeight, null);
	}
}
