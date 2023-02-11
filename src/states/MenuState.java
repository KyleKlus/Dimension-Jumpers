package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import gfx.Assets;
import input.KeyManager;
import main.Options;
import tileMap.Background;

public class MenuState extends State{
	private int keyDelay;
	private Thread thr;
	private Background bg;
	private Background bgo_1;
	private Background bgo_2;
	private Background bgo_3;
	private String[] menuO= {"Start","Options","Quit"};
	private int currentMO=0;
	private Color titleColor;
	private Font titleFont;
	private Font font;
	public MenuState (StateManager sm) {
		this.sm=sm;
		bg=new Background(Assets.background_01, 1);
		bg.setVector(0, 0);
		bgo_1=new Background(Assets.background_object_01, 1);
		bgo_1.setVector(-1, 0);
		bgo_2=new Background(Assets.background_object_02, 1);
		bgo_2.setVector(-2, 0);
		bgo_3=new Background(Assets.background_object_03, 1);
		bgo_3.setVector(-3, 0);
		titleColor = new Color(128, 0, 0);
		titleFont = new Font("Century Gothic", Font.PLAIN, 35);
		font = new Font("Arial", Font.PLAIN, 20);
		keyDelay=0;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		bg.update();
		bgo_1.update();
		bgo_2.update();
		bgo_3.update();
		if(keyDelay>=5) {
			if(KeyManager.enter) {
				select();
			}
			if(KeyManager.up) {
				currentMO--;
				if(currentMO==-1) {
					currentMO=menuO.length-1;
				}
			}
			if(KeyManager.down) {
				currentMO++;
				if(currentMO==3) {
					currentMO=0;
				}
			}
			keyDelay=0;
		}
		keyDelay++;
	}

	@Override
	public void draw(Graphics2D g) {
		try {
			thr=new Thread() {public void run() {
				bg.draw(g);
				bgo_1.draw(g);
				bgo_2.draw(g);
				bgo_3.draw(g);
			}};
		thr.start();
			thr.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		bg.draw(g);
//		bgo_1.draw(g);
//		bgo_2.draw(g);
//		bgo_3.draw(g);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString(Options.GAME_TITLE, (int)(Options.window_width*Options.graphics_scale-((35*7)/2))/2, (int)(Options.window_height*Options.graphics_scale)/2-150);
		g.setFont(font);
		for(int i=0;i<menuO.length;i++) {
			if(i==currentMO) {
				g.setColor(titleColor);
			}else {
				g.setColor(Color.BLACK);
			}
			g.drawString(menuO[i], (int)(Options.window_width*Options.graphics_scale-((20*5)/2))/2, (int)(Options.window_height*Options.graphics_scale)/2-100+i*25);
		}
	}
	private void select() {
		switch(currentMO) {
		case 0://start
			break;
		case 1://options
			sm.setState(StateManager.OPTION_STATE);
			break;
		case 2:
			System.exit(0);
			break;
		}
	}
}
