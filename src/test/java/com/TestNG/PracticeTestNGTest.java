package com.TestNG;

import org.testng.annotations.Test;

public class PracticeTestNGTest {
	
	@Test(priority = 2)
	public void createTest()
	{
		int[] x = {1,2,3};
		System.out.println(x[2]);
		System.out.println("------ Data created ------");
	}
	@Test()
	public void editDataTest()
	{
		System.out.println("------ Data modified -----");
	}
	
	@Test(invocationCount = 2, priority =0)
	public void deleteDataTest()
	{
		System.out.println("------ Data deleted");
	}
}
