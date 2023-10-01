package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class AddEmployeeTest 
{

	public static void main(String[] args) throws Throwable 
	{


		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='HR Email']"));
		email.sendKeys("hrofficer@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='HR Password']"));
		password.sendKeys("hrofficer@123");
		WebElement dd = driver.findElement(By.xpath("//select[@name='hr_type']"));
		Select s1=new Select(dd);
		s1.selectByVisibleText("→ HR Officer");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		//Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		a.accept();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
       // Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
//	    driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys("rajesh1081");
		
	}

}