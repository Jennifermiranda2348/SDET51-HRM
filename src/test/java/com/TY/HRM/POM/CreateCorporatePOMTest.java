package com.TY.HRM.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebdriverUtility;
import com.hrm.objectRepository.AddCorporatePage;
import com.hrm.objectRepository.HRHDashboardPage;
import com.hrm.objectRepository.LoginPage;

public class CreateCorporatePOMTest {

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
		
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD, "→ HR Head", hrtype);
		
//		To handle alter pop up 
		wLib.acceptAlertPopup(driver);
		
		//To click on corporate link and on add corporate
		HRHDashboardPage hrhd = new HRHDashboardPage(driver);
		AddCorporatePage acp = new AddCorporatePage(driver);
		hrhd.corporateLink();
		acp.getCorpBtn1();
//		driver.findElement(By.xpath("//i[@class='nav-icon fa fa-handshake']")).click();
//		driver.findElement(By.xpath("//p[.='Add Corporate']")).click();
//		driver.findElement(By.xpath("//h3[@class='card-title']")).click();
		
		String corpname = "Conquister";
		//Enter corporate name
		acp.AddCorpandSave(corpname);
//		driver.findElement(By.name("corporate_name")).sendKeys(corpname);
//		driver.findElement(By.xpath("//button[.='Save']")).click();
		wLib.acceptAlertPopup(driver);
		
		driver.quit();
		
	}

}
