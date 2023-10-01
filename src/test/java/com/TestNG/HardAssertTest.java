package com.TestNG;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericUtils.BaseClass;
@Listeners(com.hrm.genericUtils.ListenerClass.class)
public class HardAssertTest extends BaseClass{
	@Test 
	public void Test1()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		assertEquals("A", "B");; 
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	
	@Test 
	public void Test2()
	{
		System.out.println("Step 5");
		System.out.println("Step 6");
		assertNotEquals("A", "B");
		System.out.println("Step 7");
		System.out.println("Step 8");
	}

	@Test 
	public void ATest3()
	{
		System.out.println("Step 9");
		System.out.println("Step 10");
		int j=8;
		assertNotNull(j);
		System.out.println("Step 11");
		assertNull(j);
		System.out.println("Step 12");
	}

}
