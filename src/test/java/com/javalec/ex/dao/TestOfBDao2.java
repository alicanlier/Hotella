package com.javalec.ex.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOfBDao2 {
	
	static int cnt;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed only once at the start.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed only once at the end.");
	}

	@Before
	public void setUp() throws Exception {
		cnt++;
		System.out.println("Executed when every test starts.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(cnt+": End!");
	}

	@Test
	public void test() {
		System.out.println(cnt+" some test");
	}
	
	@Test
	public void test1() {
		System.out.println(cnt+" some test");
	}
	
	@Test
	public void test2() {
		System.out.println(cnt+" some test");
	}

}
