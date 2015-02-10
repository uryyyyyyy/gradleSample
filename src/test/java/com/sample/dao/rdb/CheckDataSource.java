package com.sample.dao.rdb;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.config.GlobalProperties;
import org.junit.Test;

public class CheckDataSource {

	@Test
	public void test() {
		EbeanServer s = Ebean.getServer("h2");
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got "+i+" - DataSource good.");
	}
}