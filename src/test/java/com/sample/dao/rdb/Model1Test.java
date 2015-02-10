package com.sample.dao.rdb;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Model1Test {

	@Test
	public void test() {
		EbeanServer s = Ebean.getServer("h2");

		Model1 e = new Model1();
		e.setId(3);
		//Model1 e = new Model1(null, "test", "something", null);
		s.save(e);
		e.description = "changed";

		// this will update
		s.save(e);

		// find the inserted entity by its id
		Model1 e2 = s.find(Model1.class, e.id);
		System.out.println("Got "+e2.description);

		s.delete(e);
	}

}