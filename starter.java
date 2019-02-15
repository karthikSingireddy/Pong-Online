import game.Game;
import sockets.SocketsThread;

public class starter {
	public static void main(String[] args) {
		Game g = new Game("Pong", 500, 700);
		g.start();
//		mainMenu m = new mainMenu(500, 500);
//		new Game("Pong", 500, 700).start();
//		test();
	}
//	public static void test() {
////		Display d = new Display("Hi", 50, 50);
////		KeyManager km = new KeyManager();
//		SocketsThread st = new SocketsThread(null);
//		st.run();
//	}
}