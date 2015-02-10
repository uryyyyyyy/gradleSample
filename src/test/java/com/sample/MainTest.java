package com.sample;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {
	@Test public void testSomeLibraryMethod() {
		assertThat("str", is("str"));
	}
}
