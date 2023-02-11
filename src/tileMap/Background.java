package tileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.Options;

public class Background {
	private BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double moveScale;
	
	public Background(BufferedImage image, double ms) {
		moveScale=ms;
		this.image=image;
	}
	public void setPos(double x, double y) {
		this.x=(x*moveScale)%(int)(Options.window_width*Options.graphics_scale);
		this.y=(y*moveScale)%(int)(Options.window_height*Options.graphics_scale);//needs work
	}
	public void setVector(double dx, double dy) {
		this.dx=dx;
		this.dy=dy;
	}
	public void update() {
		x+=dx;
		y+=dy;
	}
	public void draw(Graphics2D g) {
		Graphics2D g2d=g;
		g2d.drawImage(image, (int)x, (int)y+(int)(Options.window_height*Options.graphics_scale-image.getHeight()*Options.graphics_scale), (int)(Options.window_width*Options.graphics_scale), (int)(image.getHeight()*Options.graphics_scale), null);
		if(x<0) {
			g2d.drawImage(image, (int)x+(int)(Options.window_width*Options.graphics_scale), (int)y+(int)(Options.window_height*Options.graphics_scale-image.getHeight()*Options.graphics_scale), (int)(Options.window_width*Options.graphics_scale), (int)(image.getHeight()*Options.graphics_scale), null);
			if(x<-(int)(Options.window_width*Options.graphics_scale)) {
				x=0;
			}
		}
		if(x>0) {
			g2d.drawImage(image, (int)x-(int)(Options.window_width*Options.graphics_scale), (int)y+(int)(Options.window_height*Options.graphics_scale-image.getHeight()*Options.graphics_scale), (int)(Options.window_width*Options.graphics_scale), (int)(image.getHeight()), null);
			if(x>(int)(Options.window_width*Options.graphics_scale)) {
				x=0;
			}
		}
		g=(Graphics2D)g2d.create(0, 0, (int)(Options.window_width*Options.graphics_scale), (int)(Options.window_height*Options.graphics_scale));//extra thread
	}
}
