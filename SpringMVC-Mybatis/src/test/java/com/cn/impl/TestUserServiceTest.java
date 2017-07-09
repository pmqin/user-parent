/**
 * 
 */
package com.cn.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

/** 
* @author : pmqin
* @date   : 2016年5月2日 下午6:03:09 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class TestUserServiceTest {

	@Test
	public void test1() {
		//fail("Not yet implemented");
		int a=1+3;
		//System.out.println("sdfdsf1");
		Assert.assertEquals(4, a);
		
	}
	
	@Test
	@Ignore
	public void test2() {
		//fail("Not yet implemented");
		
		System.out.println("sdfdsf2");
	}
	
	@Test
	public void test3() {
		//fail("Not yet implemented");
		
		System.out.println("@Test");
	}
	
	@Before
	public  void testBefore() {
		//fail("Not yet implemented");
		
		System.out.println("@Before");
	}
	
	@BeforeClass
	public static void testBeforeClass() {
		//fail("Not yet implemented");
		
		System.out.println("BeforeClass");
	}
	
	@After
	public  void testAfter() {
		//fail("Not yet implemented");
		
		System.out.println("@After");
	}
	
	@AfterClass
	public static void AfterClass() {
		//fail("Not yet implemented");
		
		System.out.println("AfterClass");
	}
	
	

}
