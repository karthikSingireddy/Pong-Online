package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import game.Game;
import paddle.BluePaddle;
import paddle.Paddle;
import paddle.RedPaddle;

public class Communicator {
	
	private Game game;
	
	private final String ip = "127.0.0.1";
	private final int port = 6789;

	private ServerSocket ss;
	private Socket s;
	
//	private DataInputStream in;
//	private DataOutputStream out;

	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public Communicator(String ip, int port, Game game) {
		try {
			this.s = new Socket(ip, port);
		} catch (IOException e) {
			System.out.println("error with socket");
		}
		init();
	}
	public Communicator(int port, Game game)  {
		try {
			this.ss = new ServerSocket(this.port);
			s = ss.accept();
		} catch (Exception e) {
			System.out.println("error with server socket / socket");
		}
		init();
	}
	
	private void init() {
		try {
			this.in = new ObjectInputStream(s.getInputStream());
			this.out = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void tick(Paddle p) {
		recieve();
		send(p);
	}
	
	private void recieve() {
		Paddle pa = null;
		try {
			pa = (Paddle) this.in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pa.red) {
			game.setRedPaddle((RedPaddle)pa);
		} else {
			game.setBluPaddle((BluePaddle)pa);
		}
	}
	private void send(Paddle p) {
		
	}
}