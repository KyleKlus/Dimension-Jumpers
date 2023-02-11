package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	private boolean[] keys;
	public static boolean up, down, left, right, jump, enter;
	public KeyManager() {
		keys = new boolean[256];
	}
	public void update() {
		up=keys[KeyEvent.VK_W];
		down=keys[KeyEvent.VK_S];
		left=keys[KeyEvent.VK_A];
		right=keys[KeyEvent.VK_D];
		jump=keys[KeyEvent.VK_SPACE];
		enter=keys[KeyEvent.VK_ENTER];
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
			keys[e.getKeyCode()]=true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
		
	}

}
