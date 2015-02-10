package com.sample;

import com.sample.util.MyLogger;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Main {
	public static void main(String args[]) throws ConfigurationException {
		MyLogger.logger.info("log");

		PropertiesConfiguration config = new PropertiesConfiguration("project.properties");
		MyLogger.logger.info(config.getString("foo"));
		MyLogger.logger.info(String.valueOf(config.getInt("foo.bar")));
	}
}
