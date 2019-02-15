package sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import game.Game;

public class OnlineTest extends Thread {
	
	private String ip = "192.168.7.60";
	private int port = 49873;
	
	private Game game;
	
	private Socket s;
	
//	private ObjectInputStream oi;
	private DataInputStream oi;
	
	public boolean up, down;
	
	public OnlineTest(Game game) {
		this.game = game;
		try {
			s = new Socket(this.ip, this.port);
			System.out.println("connected");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		this.up = false;
		this.down = false;
	}
	
	public void run() {
		while(true) {
			tick();
		}
	}
	
	public void tick() {
		String o = null;
		try {
//			o = oi.readObject();
			o = oi.readUTF();
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}
		System.out.println(o);
//		if((!o.equals(null))) {
//			if(o.equals("w"))
//				this.up = true;
//			if(o.equals("s"))
//				this.down = true;
//		}
	}
}
