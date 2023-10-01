package com.TY.HRM.Hardcode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEmployeeTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("hr_email")).sendKeys("hrofficer@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("hrofficer@123");
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		Select sel = new Select(hrtype);
		sel.selectByVisibleText("→ HR Officer");
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
		Alert a = driver.switchTo().alert();
		a.accept();
		
		//To click on employee link
		driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
		
		//To click on add employee
		driver.findElement(By.xpath("//p[.='Add Employee']")).click();
		driver.findElement(By.xpath("//h3[@class='card-title']")).click();
		
		//to enter all the mandatory field in Add employee 
		driver.findElement(By.name("employee_companyid")).sendKeys("CONQ202301");
		driver.findElement(By.name("employee_firstname")).sendKeys("Jennifer");
		driver.findElement(By.name("employee_lastname")).sendKeys("Miranda");
		driver.findElement(By.name("employee_middlename")).sendKeys("Vincent");
		driver.findElement(By.name("branches_datefrom")).sendKeys("07/15/2013");
		driver.findElement(By.name("branches_recentdate")).sendKeys("07/14/2022");
		
		WebElement dep = driver.findElement(By.name("employee_department"));
		Select s = new Select(dep);
		s.selectByVisibleText("Hiring Management");
		WebElement branch = driver.findElement(By.name("employee_branches"));
		Select s1 = new Select(branch);
		s1.selectByVisibleText("JP Nagar");
		driver.findElement(By.name("employee_position")).sendKeys("Quality Assurance");
		driver.findElement(By.name("employee_contact")).sendKeys("12345678907");
		driver.findElement(By.name("employee_sss")).sendKeys("123456");
		driver.findElement(By.name("employee_tin")).sendKeys("756985462");
		driver.findElement(By.name("employee_hdmf_pagibig")).sendKeys("sadfasd");
		driver.findElement(By.name("employee_gsis")).sendKeys("457896");
		driver.findElement(By.xpath("//button[.='Save']")).click();
		
		//driver.close();
		
		

	}

}
