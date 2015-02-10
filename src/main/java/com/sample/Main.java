package com.sample;

import com.sample.util.ConfigProvider;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.LogManager;

public class Main {
	protected static final String LOGGING_PROPERTIES_DATA
			= "handlers=java.util.logging.FileHandler\n"
			+ ".level=INFO\n"
			+ "java.util.logging.ConsoleHandler.level=INFO\n"
			+ "java.util.logging.ConsoleHandler.formatter"
			+ "=java.util.logging.SimpleFormatter\n"
			+ "java.util.logging.FileHandler.pattern = ./logs/LoggingTester%u.log";

	public static void main(String args[]) throws ConfigurationException, SQLException, IOException {
		InputStream configFile = new ByteArrayInputStream(LOGGING_PROPERTIES_DATA.getBytes("UTF-8"));
		LogManager.getLogManager().readConfiguration(configFile);
		Log log = LogFactory.getLog(Main.class);
		PropertiesConfiguration config = ConfigProvider.config;
		log.info(config.getString("foo"));
		log.debug(config.getString("foo"));
		log.fatal(config.getString("foo"));
		log.error(config.getString("foo"));
		log.info(String.valueOf(config.getInt("foo.bar")));
	}
}
