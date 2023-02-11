package gfx;

import java.awt.image.BufferedImage;

import main.Log;

public class Assets {
	/*
	private final static int playerWidth=46;
	private final static int playerHeight=50;
	//backgrounds*/
	public static BufferedImage background_01;
	public static BufferedImage background_object_01;
	public static BufferedImage background_object_02;
	public static BufferedImage background_object_03;
	//groundpieces
	/*
	public static BufferedImage groundpiece_01;
	//obstacles
	public static BufferedImage obstacle_01;
	//player right
		//player standing
		public static BufferedImage player_right_standing;
		//player running
		public static BufferedImage player_right_running_01;
		//player jumping
		public static BufferedImage player_right_jumping;
		//player falling
		public static BufferedImage player_right_falling;
		//player crouching
		public static BufferedImage player_right_crouching;
	//player right
		//player standing
		public static BufferedImage player_left_standing;
		//player running
		public static BufferedImage player_left_running_01;
		//player jumping
		public static BufferedImage player_left_jumping;
		//player falling
		public static BufferedImage player_left_falling;
		//player crouching
		public static BufferedImage player_left_crouching;*/
		
	public static void init() {
		//backgrounds
		background_01 = ImageLoader.loadImage("/textures/background/sunset.png");
		background_object_01 = ImageLoader.loadImage("/textures/background/cityskyline_rear.png");
		background_object_02 = ImageLoader.loadImage("/textures/background/cityskyline_front.png");
		//background_object_03 = ImageLoader.loadImage("/textures/background/roof.png");
		//groundpieces
		/*groundpiece_01 = ImageLoader.loadImage("/textures/world/rooftop_blank.png");
		//obstacles
		obstacle_01 = ImageLoader.loadImage("/textures/world/rooftop_wall_edge.png");
		//player right
			SpriteSheet spsh = new SpriteSheet(ImageLoader.loadImage("/textures/character/player_right_spritemap_green.png"));
			//player standing
			player_right_standing = spsh.crop(playerWidth*0, playerHeight*0, playerWidth, playerHeight);
			//player running
			player_right_running_01 = spsh.crop(playerWidth*0, playerHeight*3, playerWidth, playerHeight);
			//player jumping
			player_right_jumping = spsh.crop(playerWidth*6, playerHeight*0, playerWidth, playerHeight);
			//falling
			player_right_falling = spsh.crop(playerWidth*7, playerHeight*0, playerWidth, playerHeight);
			//player crouching
			player_right_crouching = spsh.crop(playerWidth*1, playerHeight*0, playerWidth, playerHeight);
		//player left
			spsh = new SpriteSheet(ImageLoader.loadImage("/textures/character/player_left_spritemap_green.png"));
			//player standing
			player_left_standing = spsh.crop(playerWidth*7, playerHeight*0, playerWidth, playerHeight);
			//player running
			player_left_running_01 = spsh.crop(playerWidth*7, playerHeight*3, playerWidth, playerHeight);
			//player jumping
			player_left_jumping = spsh.crop(playerWidth*1, playerHeight*0, playerWidth, playerHeight);
			//falling
			player_left_falling = spsh.crop(playerWidth*0, playerHeight*0, playerWidth, playerHeight);
			//player crouching
			player_left_crouching = spsh.crop(playerWidth*6, playerHeight*0, playerWidth, playerHeight);*/
		Log.INFO("Assets initialized");
	}
}
