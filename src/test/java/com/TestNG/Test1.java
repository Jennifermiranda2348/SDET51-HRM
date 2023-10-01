package com.TestNG;

import org.testng.annotations.Test;

import com.hrm.genericUtils.BaseClass;

public class Test1 extends BaseClass{
	@Test(groups = "smoke")
	public void sample() {
	System.out.println("Get some samples");
	}
	@Test
	public void impactArea()
	{
		System.out.println("Impact area is found");
	}

}
