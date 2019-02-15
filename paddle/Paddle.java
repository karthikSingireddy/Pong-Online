package paddle;

import java.awt.Graphics;

import game.Game;

public abstract class Paddle{
	protected final int speed;
	
	public boolean red;
	
	public int velY;
	
	public int x;
    public Paddle(Game game) {
        this.game = game;
        speed = 10;
    }
    public Paddle(Game game, int f) {
    	this(game);
    }
    protected Game game;
    
    protected int y;
    
    
    public int getY() {
    	return this.y;
    }
    public int getX() {
    	return this.x;
    }
    
    public void setY(int y) {
    	this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract int getXBorder();
    public abstract int getFarXBorder();
}