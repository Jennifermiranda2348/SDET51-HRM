package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	@Test 
	public void Test1()
	{
		String exp ="OrangeHRM";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String actual = driver.getTitle();
		System.out.println(actual);
			
		SoftAssert SA = new SoftAssert();
		SA.assertEquals(actual, exp);
		System.out.println("Failed but still executed the following line of code");
		System.out.println("execution ends");
		SA.assertAll();
		
	}
}
