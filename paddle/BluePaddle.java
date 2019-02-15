package paddle;

import java.awt.Graphics;

import assets.Assets;
import game.Game;
import game.KeyManager;

public class BluePaddle extends Paddle {
	private KeyManager keymanager;
	
//    private static final int x = 50;
    public BluePaddle(Game game) {
        super(game);
        keymanager = game.getKeyManager();
        super.x = (int) (game.width * 0.05);
        super.red = false;
        super.velY = 0;
    }
    
    @Override
    public int getXBorder() {
    	return super.x + Assets.paddleWidth*2;
    }
    @Override
    public int getFarXBorder() {
    	return super.x;
    }
    
    public class f extends BluePaddle {

		public f(Game game) {
			super(game);
			// TODO Auto-generated constructor stub
		}
    	
    }
    
    @Override
    public void tick() {
    	if(keymanager.w && super.y != 0) {
    		super.y -= super.speed;
    		super.velY = super.speed;
    	}
    	if(keymanager.s && super.y  + Assets.paddleHeight != game.height) {
    		super.y += super.speed;
    		super.velY = -super.speed;
    	}
    }
	public void render(Graphics g) {
		g.drawImage(Assets.bluePaddle, super.x, super.y, Assets.paddleWidth, Assets.paddleHeight, null);
	}
}