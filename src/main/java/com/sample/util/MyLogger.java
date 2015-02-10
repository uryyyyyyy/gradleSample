package com.sample.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class MyLogger {

	public static Logger logger = init();

	private static Logger init() {
		try {
			final String LOGGER_NAME = "MyLogger";
			File newdir = new File("./log");
			if(!newdir.mkdir()){
				throw new RuntimeException();
			}
			Logger logger = Logger.getLogger(LOGGER_NAME);
			Handler handler = new FileHandler("./log/java%u.log");
			handler.setFormatter(new SimpleFormatter());
			handler.setLevel(Level.CONFIG);
			logger.setLevel(Level.CONFIG);
			//"MyLogger"に作成したハンドラーを設定
			logger.addHandler(handler);
			return logger;
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}

}