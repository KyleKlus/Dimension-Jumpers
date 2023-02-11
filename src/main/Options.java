package main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Options {
	//dev options
	public static boolean dev_mode;
	public static boolean event_logging;
	//window options
	public static final String GAME_TITLE="Roofers";
	public static boolean show_fps;
	public static int ups_limit;
	public static int fps_limit;
	public static double graphics_scale;
	public static int window_width;
	public static int window_height;
	//Gameoptions
	public static int player_count;
	
	public static void load() {
		try {
			FileReader configFile = new FileReader("res/config/config");
			Properties properties = new Properties();
			try {
				properties.load(configFile);
				if(properties.getProperty("dev_mode").equals("true")) {
					dev_mode=true;
				}else {
					dev_mode=false;
				}
				if(properties.getProperty("event_logging").equals("true")) {
					event_logging=true;
				}else {
					event_logging=false;
				}
				if(properties.getProperty("show_fps").equals("true")) {
					show_fps=true;
				}else {
					show_fps=false;
				}
				graphics_scale=Double.parseDouble(properties.getProperty("graphics_scale"));
				ups_limit=Integer.parseInt(properties.getProperty("ups_limit"));
				fps_limit=Integer.parseInt(properties.getProperty("fps_limit"));
				window_width=Integer.parseInt(properties.getProperty("window_width"));
				window_height=Integer.parseInt(properties.getProperty("window_height"));
				player_count=Integer.parseInt(properties.getProperty("player_count"));
				configFile.close();
				Log.INFO("Config loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void save() {
		try {
			FileWriter configFile = new FileWriter("res/config/config");
			Properties properties = new Properties();
			properties.setProperty("dev_mode", Boolean.toString(dev_mode));
			properties.setProperty("event_logging", Boolean.toString(event_logging));
			properties.setProperty("show_fps", Boolean.toString(show_fps));
			properties.setProperty("graphics_scale", Double.toString(graphics_scale));
			properties.setProperty("ups_limit", Integer.toString(ups_limit));
			properties.setProperty("fps_limit", Integer.toString(fps_limit));
			properties.setProperty("window_width", Integer.toString(window_width));
			properties.setProperty("window_height", Integer.toString(window_height));
			properties.setProperty("player_count", Integer.toString(player_count));
			properties.store(configFile, null);
			configFile.close();
			Log.INFO("Config saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
