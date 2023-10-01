package com.TY.HRM.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebdriverUtility;

public class DeleteEmployeePOMTest {

	public static void main(String[] args) throws Throwable {
		//To fetch data from property file
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
				
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
		wLib.selectDropDown("→ HR Officer", hrtype);
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
		wLib.acceptAlertPopup(driver);
		
		//To handle alert pop up 
		wLib.acceptAlertPopup(driver);
		
		//To click on employee link
		driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
		
		//To click on add employee
		driver.findElement(By.xpath("//p[.='Add Employee']")).click();
		
		//To click on search field
		String empname = "rajesh108165";
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(empname);
		driver.findElement(By.xpath("//i[@class='fa fa-trash']")).click();
		
		//if(empname=)
		
		
		
		

	}

}
