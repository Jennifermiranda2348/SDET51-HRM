package com.TY.HRM.Hardcode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteEmployeeTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("hr_email")).sendKeys("hrassistant@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("hrassistant@123");
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		Select sel = new Select(hrtype);
		sel.selectByVisibleText("→ HR Assistant");
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
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
