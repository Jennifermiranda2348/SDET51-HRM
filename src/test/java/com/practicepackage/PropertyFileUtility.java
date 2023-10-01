package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.JavaUtility;
import com.hrm.genericUtils.WebdriverUtility;

public class PropertyFileUtility {

	public static void main(String[] args) throws Throwable {
		WebdriverUtility wLib = new WebdriverUtility();
		FileUtility fLib = new FileUtility();
				
		Properties pro = new Properties();
		pro.setProperty("Browser","Firefox");
		pro.setProperty("url", "http://rmgtestingserver/domain/HRM_System/");
		pro.setProperty("username2","hrhead@gmail.com");
		pro.setProperty("password2","hrhead@123");
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\CommanData1.properties");
		pro.store(fout, "write data");
		fout.close();
		
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		WebDriver driver = new ChromeDriver();

		wLib.maximizeTheBrowser(driver);
		driver.get(URL);
		wLib.implicitWait(driver, 10);
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		wLib.selectDropDown("→ HR Assistant", hrtype);
		driver.findElement(By.name("login_hr")).click();
		
		wLib.acceptAlertPopup(driver);
	}

}
