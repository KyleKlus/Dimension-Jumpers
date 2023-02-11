package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Log {
	private static String logtext="INFO: Log started";
	
	public static void ERROR(String message) {
		if(Options.dev_mode) {
			System.out.println("ERROR: "+message);
		}
		if(Options.event_logging) {
	        logtext+="\nERROR: "+message;
		}
	}
	public static void WARNING(String message) {
		if(Options.dev_mode) {
			System.out.println("WARNING: "+message);
		}
		if(Options.event_logging) {
	        logtext+="\nWARNING: "+message;
		}
	}
	public static void DEBUG(String message) {
		if(Options.dev_mode) {
			System.out.println("DEBUG: "+message);
		}
	}
	public static void INFO(String message) {
		if(Options.dev_mode) {
			System.out.println("INFO: "+message);
		}
		if(Options.event_logging) {
	        logtext+="\nINFO: "+message;
		}
	}
	
	public static void save() {
		if(Options.event_logging) {
			try {
	        	File logFile = new File("res/log/output_log.txt");//Change to /log
	        	logtext+="\nINFO: Log stopped";
				if (logFile.createNewFile()) {
				    Log.INFO("File created: " + logFile.getName());
				    FileOutputStream outputStream = new FileOutputStream(logFile);
				    Log.INFO("Log saved");
				    byte[] strToBytes = logtext.getBytes();
				    outputStream.write(strToBytes);
				    outputStream.close();
				  } else {
					    FileOutputStream outputStream = new FileOutputStream(logFile);
					    Log.INFO("Log saved");
					    byte[] strToBytes = logtext.getBytes();
					    outputStream.write(strToBytes);
					    outputStream.close();
				  }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
