package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import gfx.Assets;
import input.KeyManager;
import states.StateManager;
import threads.RenderThread;
import threads.UpdateThread;

public class Game{
	private KeyManager km;
	public static JFrame window;
	private Canvas cnvs;
	private UpdateThread ut;
	private RenderThread rt;
	private StateManager sm;
	
	public Game() {
		createDisplay();
	}
	private void init() {
		Assets.init();
		km=new KeyManager();
		sm=new StateManager();
		window.addKeyListener(km);
		ut=new UpdateThread(sm, km);
		rt=new RenderThread(sm, cnvs);
		Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
            	ut.setRunning(false);
            	rt.setRunning(false);
            	Options.save();
        		Log.save();
            }
        });
		Log.INFO("Initializing done");
	}
	public void start() {
		init();
		ut.start();
		rt.start();
	}
	private void createDisplay() {
		window = new JFrame(Options.GAME_TITLE);
		cnvs=new Canvas();
		cnvs.setMinimumSize(new Dimension((int)(Options.window_width*Options.graphics_scale), (int)(Options.window_height*Options.graphics_scale)));
		cnvs.setPreferredSize(new Dimension((int)(Options.window_width*Options.graphics_scale), (int)(Options.window_height*Options.graphics_scale)));
		cnvs.setMaximumSize(new Dimension((int)(Options.window_width*Options.graphics_scale), (int)(Options.window_height*Options.graphics_scale)));
		window.add(cnvs);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	public static void main(String[] args) {
		Options.load();
		new Game().start();
	}
}
