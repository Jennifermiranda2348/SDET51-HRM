package com.TestNG;

import org.testng.annotations.Test;

import com.hrm.genericUtils.BaseClass;

public class Test0 extends BaseClass{
	
	@Test(groups = "regression")
	public void demo() {
	System.out.println("hello selenium");
	}
	@Test
	public void regional()
	{
		System.out.println("Regional regression test executed");
	}

}
