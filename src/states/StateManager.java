package states;

import java.awt.Graphics2D;
import java.util.ArrayList;

import main.Log;

public class StateManager {
	private ArrayList<State> states;
	private int currentState;
	
	public static final int MENU_STATE=0;
	public static final int OPTION_STATE=1;
	
	public StateManager() {
		states = new ArrayList<State>();
		currentState=MENU_STATE;
		states.add(new MenuState(this));
		states.add(new OptionState(this));
		Log.INFO("All states loaded");
	}
	public void setState(int state) {
		currentState=state;
		states.get(currentState).init();
	}
	public synchronized void update() {
		states.get(currentState).update();
	}
	public synchronized void draw(Graphics2D g) {
		states.get(currentState).draw(g);
	}
}
