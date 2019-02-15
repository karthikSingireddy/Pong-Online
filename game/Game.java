package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Scoring.ScoreBoard;
import assets.Assets;
import display.Display;
import paddle.BluePaddle;
import paddle.RedPaddle;
import sockets.SocketsThread;

public class Game implements Runnable {
    private Display display;
    
    public String title;
    public int width;
    public int height;
    public boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private Thread thread;

    private KeyManager keymanager;
    
    private BluePaddle bluPaddle;
    private RedPaddle redPaddle;
    private Ball ball;
    private Ball[] balls;
    
    private ScoreBoard scoreboard;
    
    private SocketsThread st;
    
    public SocketsThread getSt() {
    	return this.st;
    }
    
    
    
    public ScoreBoard getScoreBoard() {
    	return this.scoreboard;
    }
    
    public Game(String title, int height, int width) {
        this.title = title;
        this.height = height;
        this.width = width;
        this.display = new Display(title, width, height);
        this.display.canvasSetup();
        keymanager = new KeyManager();
        this.balls = new Ball[10];
        this.scoreboard = new ScoreBoard(this);
        st = new SocketsThread(this);
    }
    
    public Game(Display display) {
    	this.display = display;
    	this.width = display.getFrame().getWidth();
    	this.height = display.getFrame().getHeight();
    	keymanager = new KeyManager();
    	this.scoreboard = new ScoreBoard(this);
    }
    
    public void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keymanager);
        Assets.load();
        bluPaddle = new BluePaddle(this);
        redPaddle = new RedPaddle(this);
        ball = new Ball(this, 25);
//        for(int i = 0; i < balls.length; i++) {
//        	this.balls[i] = new Ball(this, 10);
//        }
        
    }

    private void tick() {
    	this.keymanager.tick();
    	this.bluPaddle.tick();
    	this.redPaddle.tick();
    	this.ball.tick();
    	this.scoreboard.tick();
//    	for(int i = 0; i < this.balls.length; i++) {
//    		this.balls[i].tick();
//    	}
    	if(this.keymanager.exit) {
    		this.display.getFrame().dispose();
    		System.exit(1);
    	}
    	
//    	System.out.println(keymanager.w);
    }
    public boolean spongebob = false;
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);
        
        
        
        // Call other render methods here
        if(this.spongebob) g.drawImage(Assets.spongebob, 0, 0, this.width, this.height, null);
        
        this.scoreboard.render(g);
        this.bluPaddle.render(g);
        this.redPaddle.render(g);
        this.ball.render(g);
//        for(int i = 0; i < this.balls.length; i++) {
//        	this.balls[i].render(g);
//        }
        
        bs.show();
        g.dispose();
    }
    
    public void run() {
    	init();
//        o.start();
//        st.start();
        
        System.out.println("init done");
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            // Math for limiting frames
            now = System.nanoTime();
        	delta += (now-lastTime) / timePerTick;
        	timer += now-lastTime;;
        	lastTime = now;
        	if(delta>=1) {
        		tick();
        		render();
        		ticks++;
        		delta--;
            }
            
            if(timer >= 1000000000) {
                // Message for frames can be put here
                // use ticks for amount of frames per second
            }
        }
        stop();
    }



    public synchronized void start () {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
        st.start();
        running = true;
    }
    public synchronized void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public KeyManager getKeyManager() {
        return this.keymanager;
    }
    
    public BluePaddle getBluPaddle() {
    	return this.bluPaddle;
    }
    public void setBluPaddle(BluePaddle p) {
    	this.bluPaddle = p;
    }
    
    public RedPaddle getRedPaddle() {
    	return this.redPaddle;
    }
    public void setRedPaddle(RedPaddle p) {
    	this.redPaddle = p;
    }
    
}