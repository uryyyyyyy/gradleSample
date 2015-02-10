package com.sample;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.SqlRow;
import com.sample.dao.rdb.Model1;
import com.sample.util.MyLogger;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String args[]) throws ConfigurationException, SQLException {
		MyLogger.logger.info("log");
		PropertiesConfiguration config = new PropertiesConfiguration("project.properties");
		MyLogger.logger.info(config.getString("foo"));
		MyLogger.logger.info(String.valueOf(config.getInt("foo.bar")));

		EbeanServer s = Ebean.getServer("maria");
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got " + i + " - DataSource good.");
	}
}
