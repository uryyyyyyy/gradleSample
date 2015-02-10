package com.sample.dao.rdb;

import com.avaje.ebean.Ebean;
import org.junit.Test;

public class Model1Test {

	@Test
	public void test() {
		//System.setProperty("catalina.base", "D:/apps/tomcat6");
		//System.setProperty("ebean.props.file", "D:/apps/tomcat6/conf/zsite.ebean.properties");
		//GlobalProperties.put("ebean.debug.sql", "true");

		Model1 e = new Model1();
		e.name = "test";
		e.description = "something";

		// will insert
		Ebean.save(e);

		e.description = "changed";

		// this will update
		Ebean.save(e);

		// find the inserted entity by its id
		Model1 e2 = Ebean.find(Model1.class, e.getId());
		System.out.println("Got "+e2.getDescription());

		Ebean.delete(e);
		// can use delete by id when you don't have the bean
		//Ebean.delete(ESimple.class, e.getId());
	}
}