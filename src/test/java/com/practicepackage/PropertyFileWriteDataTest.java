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

public class PropertyFileWriteDataTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
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
		
//		FileInputStream fis= new FileInputStream("./src/test/resources/CommanData.properties");
//		Properties pro1 = new Properties();				
//		pro1.load(fis);
		
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);
		driver.get(URL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implicitWait(driver, 10);
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement hrtype = driver.findElement(By.id("hr_type"));
//		Select sel = new Select(hrtype);
//		sel.selectByVisibleText("→ HR Assistant");
		wLib.selectDropDown("→ HR Assistant", hrtype);
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
//		Alert a = driver.switchTo().alert();
//		a.accept();
		wLib.acceptAlertPopup(driver);
	}

}
