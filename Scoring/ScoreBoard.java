package Scoring;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import assets.Assets;
import display.Display;
import game.Game;

public class ScoreBoard {
	
	private int x;
	private int y;
	
	private int redScore;
	private int blueScore;
	
	public int getRedScore() { return this.redScore;}
	public int getBlueScore() {return this.blueScore;}
	
	public void setRedScore(int score) { this.redScore = score;}
	public void setBlueScore(int score) { this.redScore = score;}
	
	public void increaseRed() {this.redScore++;}
	public void increaseBlue() {this.blueScore++;}
	
	private Game game;
	private Display display;
	
	public ScoreBoard(Game game) {
		this.game = game;
		this.x = game.width/2; // - (Assets.scoreBoardBackground.getWidth()/2);
		this.y = 0;
		this.redScore = 0;
		this.blueScore = 0;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.drawImage(Assets.scoreBoardBackground, x /*(game.width/2) - Assets.scoreBoardBackground.getWidth()*/, y, 100, 50, null);
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(blueScore-1), x + 15, 25);
//		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(redScore), x + 75, 25);
		
	}
}
