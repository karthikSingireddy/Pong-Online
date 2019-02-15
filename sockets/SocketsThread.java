package sockets;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import game.Game;

public class SocketsThread extends Thread{
//	public static void main(String[] args) {
//		System.out.println("hello");
//		new SocketsThread().start();
//		System.out.println("done");
//	}
	String ip = "192.168.7.60";
//	String ip = "127.0.0.1";
//	String ip = "192.168.137.1";
	int port = 49873;
	
	ServerSocket ss;
	Socket s;
	
	ObjectOutputStream oo;
//	ObjectInputStream oi;
	DataInputStream oi;
	
	
	public SocketsThread(Game game) {
		System.out.println("constructor");
		try {
			this.s = new Socket("192.168.7.60", 49873);
//			this.oi = new ObjectInputStream(s.getInputStream());
			this.oi = new DataInputStream(s.getInputStream());
			this.oo = new ObjectOutputStream(s.getOutputStream());
			System.out.println("sockets done");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean up = false;
	public boolean down = false;
	
	public void run() {
		System.out.println("run started");
		int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
		while(true) {
			now = System.nanoTime();
        	delta += (now-lastTime) / timePerTick;
        	timer += now-lastTime;
        	lastTime = now;
        	if(delta>=1) {
        		synchronized (this) {
        			tick();
        		}
        		ticks++;
        		delta--;
            }
		}
	}	
	boolean f = false;
	public void tick() {
		String o = null;
		try {
			o = oi.readUTF();
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			this.up = false;
			this.down = false;
		}
		if(!o.equals(null)) {
			if(o instanceof String) {
				up = o.equals("w");
				down = o.equals("s");
			}
		}
		System.out.println(o);
	}
}