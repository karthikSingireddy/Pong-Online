package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	/*

    public boolean[] keys;
    public boolean w, s, up, down;

    public KeyManager() {
        keys = new boolean[1000];
    }

    public void tick() {
        w = keys[KeyEvent.VK_W];
        s = keys[KeyEvent.VK_S];
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
		System.out.println("something is pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode() + "is typed");
	}
    */
	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean w, s;

	public boolean plus, minus, enter, shift;
	public boolean arrowUp, arrowDown, arrowLeft, arrowRight;

	public boolean exit;
	
	public KeyManager() {
	keys = new boolean[1000];
	}

	public void tick() {
		up = keys[KeyEvent.VK_W];
		w = up;
		down = keys[KeyEvent.VK_S];
		s = down;
		right = keys[KeyEvent.VK_D];
		left = keys[KeyEvent.VK_A];
		plus = keys[KeyEvent.VK_EQUALS];
		minus = keys[KeyEvent.VK_MINUS];
		enter = keys[KeyEvent.VK_ENTER];
		shift = keys[KeyEvent.VK_SHIFT];
	
		arrowUp = keys[KeyEvent.VK_UP];
		arrowDown = keys[KeyEvent.VK_DOWN];
		arrowRight = keys[KeyEvent.VK_RIGHT];
		arrowLeft = keys[KeyEvent.VK_LEFT];
		
		exit = keys[KeyEvent.VK_ESCAPE];

//		System.out.println("up is "+ KeyEvent.VK_DOWN);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
//		System.out.println(e.getKeyCode() + "pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
//		System.out.println(e.getKeyCode() + " released");
	}


}