package com.TY.HRM.POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebdriverUtility;
import com.hrm.objectRepository.HRHDashboardPage;
import com.hrm.objectRepository.LoginPage;

public class LogoutUsingPomTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		
		//To fetch data from property file
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
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
		
		LoginPage lp = new LoginPage(driver);
		WebElement hrtype = lp.getUserType();
		lp.loginToApp(USERNAME, PASSWORD,"→ HR Assistant",hrtype);
		
		//To handle alter pop up 
		wLib.acceptAlertPopup(driver);
		
		//to logout from HR Officer
		HRHDashboardPage hrhp = new HRHDashboardPage(driver);
		hrhp.logout();
		
		wLib.acceptAlertPopup(driver);
		wLib.closeBrowser(driver);
	
	}

}
