package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TwoTestTwoClassTest {
	@BeforeSuite 
	public void confDB()
	{
		System.out.println("Connect to DB");
	}
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("Launch Browser");
	}
	@BeforeMethod
	public void loginToApp()
	{
		System.out.println("Login to application");
	}
	@Test
	public void executeScript()
	{
		System.out.println("Script executed - 2");
	}
		@AfterMethod
	public void logoutApp()
	{
		System.out.println("Logout from application");
	}
	@Test
	public void executeScript1()
	{
		System.out.println("Script executed again - 2");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close the Browser");
	}
	@AfterSuite
	public void CloseDB()
	{
		System.out.println("Disconnect Database");
	}
	@Test
	public void executeScript2()
	{
		System.out.println("Am i executed - 2");
	}
}
