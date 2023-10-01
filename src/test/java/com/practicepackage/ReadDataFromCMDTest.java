package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ReadDataFromCMDTest {
	@Test
	public void cmdTest() throws Throwable
	{
		String BROWSER = System.getProperty("Browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement ele = driver.findElement(By.id("hr_type"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("→ HR Assistant");
		driver.findElement(By.name("login_hr")).click();
		
		
		
	}

}
