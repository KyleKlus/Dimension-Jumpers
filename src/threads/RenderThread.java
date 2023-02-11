package threads;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import main.Log;
import main.Options;
import states.StateManager;

public class RenderThread extends Thread{
	private StateManager sm;
	private Canvas cnvs;
	private BufferStrategy bs;
	private Graphics2D g2d;
	private boolean running=false;
	public RenderThread(StateManager sm, Canvas cnvs){
		this.sm=sm;
		this.cnvs=cnvs;
	}
	public void run() {
		Log.INFO("RenderThread started");
		running=true;
		long lastTime=System.nanoTime();
		double timePerTick=1000000000/Options.fps_limit;//1Billion Nanoseconds=1Second
		int frames=0;
		long now=0;
		double delta=0;
		long lastTimer=System.currentTimeMillis();
		while(running) {
			//Clock code
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			lastTime=now;
			if(delta>=1) {
				frames++;
				draw();
				delta--;
			}
			if(System.currentTimeMillis()-lastTimer>=1000) {
				lastTimer+=1000;
				Log.DEBUG("Fps: "+frames);
				frames=0;
			}
		}
		Log.INFO("RenderThread stopped");
	}
	private void draw() {
		bs = cnvs.getBufferStrategy();
		if(bs==null) {
			cnvs.createBufferStrategy(3);
			return;
		}
		g2d=(Graphics2D)bs.getDrawGraphics();
		sm.draw(g2d);
		bs.show();
		//g2d.dispose();
	}
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running=running;
	}
}