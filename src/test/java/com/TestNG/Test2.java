package com.TestNG;

import org.testng.annotations.Test;

import com.hrm.genericUtils.BaseClass;

public class Test2 extends BaseClass{
	@Test(groups = {"smoke","regression"})
	public void trial() {
	System.out.println("Get trail free");
	}

}
