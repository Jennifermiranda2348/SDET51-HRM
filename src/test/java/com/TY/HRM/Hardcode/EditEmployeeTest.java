package com.TY.HRM.Hardcode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditEmployeeTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("hr_email")).sendKeys("hrhead@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("hrhead@123");
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		Select sel = new Select(hrtype);
		sel.selectByVisibleText("→ HR Head");
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
		Alert a = driver.switchTo().alert();
		a.accept();
		
		//To click on employee link
		driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
		
		//To click on add employee
		driver.findElement(By.xpath("//p[.='Add Employee']")).click();
		
		//Enter name and search employee to edit
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys("amrutha");
		
		
		//to enter all the mandatory field in Add employee 
		driver.findElement(By.name("employee_companyid")).sendKeys("1");
		driver.findElement(By.name("employee_firstname")).sendKeys("amrutha");
		driver.findElement(By.name("employee_lastname")).sendKeys("t");
		driver.findElement(By.name("employee_middlename")).sendKeys("ammu");
		driver.findElement(By.name("branches_datefrom")).sendKeys("06/07/2022");
		driver.findElement(By.name("branches_recentdate")).sendKeys("08/08/2022");
		
		WebElement dep = driver.findElement(By.name("employee_department"));
		Select s = new Select(dep);
		s.selectByVisibleText("Asset Management Department200");
		WebElement branch = driver.findElement(By.name("employee_branches"));
		Select s1 = new Select(branch);
		s1.selectByVisibleText("chennai");
		driver.findElement(By.name("employee_position")).sendKeys("1");
		driver.findElement(By.name("employee_contact")).sendKeys("09947578586");
		driver.findElement(By.name("employee_sss")).sendKeys("33");
		driver.findElement(By.name("employee_tin")).sendKeys("76");
		driver.findElement(By.name("employee_hdmf_pagibig")).sendKeys("445");
		driver.findElement(By.name("employee_gsis")).sendKeys("543");
// update button
		
		//to logout from HR Head
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
		a.accept();
		
		//Login to HR Officer
		driver.findElement(By.name("hr_email")).sendKeys("hrofficer@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("hrofficer@123");
		WebElement hrtype1 = driver.findElement(By.id("hr_type"));
		Select sel1 = new Select(hrtype1);
		sel1.selectByVisibleText("→ HR Officer");
		driver.findElement(By.name("login_hr")).click();
		//driver.close();
		
		

	}

}
