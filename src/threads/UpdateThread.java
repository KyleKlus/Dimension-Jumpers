package threads;

import input.KeyManager;
import main.Log;
import main.Options;
import states.StateManager;

public class UpdateThread extends Thread{
	private StateManager sm;
	private KeyManager km;
	private boolean running=false;
	public UpdateThread(StateManager sm, KeyManager km){
		this.sm=sm;
		this.km=km;
	}
	public void run() {
		Log.INFO("UpdateThread started");
		running=true;
		long lastTime=System.nanoTime();
		double timePerTick=1000000000/Options.ups_limit;//1Billion Nanoseconds=1Second
		int updates=0;
		long now=0;
		double delta=0;
		long lastTimer=System.currentTimeMillis();
		while(running) {
			//Clock code
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			lastTime=now;
			if(delta>=1) {
				updates++;
				update();//Variables get processed & changed
				delta--;
			}
			if(System.currentTimeMillis()-lastTimer>=1000) {
				lastTimer+=1000;
				Log.DEBUG("Ups: "+updates);
				updates=0;
			}
		}
		Log.INFO("UpdateThread stopped");
	}
	private void update() {
		km.update();
		sm.update();
	}
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running=running;
	}
}

