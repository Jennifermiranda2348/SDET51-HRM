package com.TestNG.HRH;


import java.util.HashMap;
import java.util.Map.Entry;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericUtils.BaseClass;
import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebdriverUtility;
import com.hrm.objectRepository.AddAdminPage;
import com.hrm.objectRepository.HRHDashboardPage;
import com.hrm.objectRepository.LoginPage;

@Listeners(com.hrm.genericUtils.ListenerClass.class)
public class CreateAdminTestNGTest extends BaseClass {

	HRHDashboardPage hrhd = new HRHDashboardPage(driver);
	
	AddAdminPage aap = new AddAdminPage(driver);
	
	@BeforeMethod 
	public void configBM() throws Throwable
	{
		
//		To fetch data from property file
		String USERNAME = fLib.getPropertyKeyValue("username2");
		String PASSWORD = fLib.getPropertyKeyValue("password2");
//		WebElement hrtype = driver.findElement(By.id("hr_type"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getUserName().sendKeys(USERNAME);
		lp.getPassword().sendKeys(PASSWORD);
		wLib.selectDropDown(PASSWORD, lp.getUserType());
		lp.getLoginBtn().click();
						
//		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
//		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);		
				
		
//		wLib.selectDropDown("→ HR Head", hrtype);
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
		wLib.acceptAlertPopup(driver);
		
		System.out.println("Logged in to application");
	}
		@Test
		public void createAdminTestNGTest() throws Throwable
		{
		//To click on Admin link
			
		hrhd.adminLink();
		aap.clickOnAdmin();
		
		//to enter all the mandatory field in Add employee fetching data from excel
		eLib.getRowCount("Admin");

		HashMap<String, String> map = eLib.getMultipleDataFromExcel("Admin", 0, 1, driver);

		WebElement position = driver.findElement(By.id("hr_type"));
		wLib.selectDropDown("→ HR Officer", position);

		driver.findElement(By.xpath("//button[.='Save']")).click();
		wLib.acceptAlertPopup(driver);
		}
		//Logout from HR Head
		@AfterMethod()
		public void configAM()
		{
		hrhd.logout();
		wLib.acceptAlertPopup(driver);
		System.out.println("-----Logged out of application------");
		}
	}


