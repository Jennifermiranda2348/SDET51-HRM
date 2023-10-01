package com.TY.HRM.POM;


import java.util.HashMap;
import java.util.Map.Entry;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebdriverUtility;
import com.hrm.objectRepository.AddAdminPage;
import com.hrm.objectRepository.HRHDashboardPage;
import com.hrm.objectRepository.LoginPage;

public class CreateAdminPOMTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		//To fetch data from property file
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username2");
		String PASSWORD = fLib.getPropertyKeyValue("password2");
				
		WebDriver driver = null;
				
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		wLib.maximizeTheBrowser(driver);
		
		driver.get(URL);
		wLib.implicitWait(driver, 10);
				
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		wLib.selectDropDown("→ HR Head", hrtype);
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
		wLib.acceptAlertPopup(driver);
		
		//To click on Admin link
		HRHDashboardPage hrhd = new HRHDashboardPage(driver);
		AddAdminPage aap = new AddAdminPage(driver);
		
		hrhd.adminLink();
		aap.clickOnAdmin();
		
		//to click on Add admin
//		driver.findElement(By.xpath("//p[.='Add Admin']")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'Add Admin')]")).click();
		
		//to enter all the mandatory field in Add employee fetching data from excel
		eLib.getRowCount("Admin");
		
		HashMap<String, String> map = eLib.getMultipleDataFromExcel("Admin", 0, 1, driver);
		
		WebElement position = driver.findElement(By.id("hr_type"));
		wLib.selectDropDown("→ HR Officer", position);
		
		driver.findElement(By.xpath("//button[.='Save']")).click();
		wLib.acceptAlertPopup(driver);
		
		//Logout from HR Head
		hrhd.logout();

		wLib.acceptAlertPopup(driver);
		
		driver.close();
		
		
	}

}
