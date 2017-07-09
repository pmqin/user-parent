package org.user.test2;

import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import pmqin.com.XML.createXML;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	
	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void testDome4j() {
		createXML app = new createXML();
		app.parseXML();
	}
}
