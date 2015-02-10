package com.sample.dao.rdb;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.SqlRow;

/**
 * Created by shiba on 15/02/10.
 */
public class MariaUtil {

	public static void meth(){
		EbeanServer s = Ebean.getServer("maria");
		String sql = "select count(*) as count from dual";
		SqlRow row = s.createSqlQuery(sql).findUnique();
		Integer i = row.getInteger("count");
		System.out.println("Got " + i + " - DataSource good.");
	}
}
