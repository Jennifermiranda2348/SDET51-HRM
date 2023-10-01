package com.TY.HRM.ExtData;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteEmployeeExtdataTest {

	public static void main(String[] args) throws Throwable {
//To fetch data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
		Properties pro = new Properties();
		pro.load(fis);
				
		String BROWSER = pro.getProperty("Browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username1");
		String PASSWORD = pro.getProperty("password1");
				
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
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		Select sel = new Select(hrtype);
		sel.selectByVisibleText("→ HR Officer");
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alert pop up 
		Alert a = driver.switchTo().alert();
		a.accept();
		
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
