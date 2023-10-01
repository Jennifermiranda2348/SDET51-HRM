package com.TY.HRM.ExtData;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEmployeeExtdataTest {

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
		driver.findElement(By.xpath("//h3[@class='card-title']")).click();
		
		//to enter all the mandatory field in Add employee fetching data from excel
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Employee");
		int count = sh.getLastRowNum();
		
		
		HashMap<String,String> map= new HashMap<String,String>();
		for(int i=0;i<count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String,String> s:map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
//		driver.findElement(By.name("employee_companyid")).sendKeys("CONQ202301");
//		driver.findElement(By.name("employee_firstname")).sendKeys("Jennifer");
//		driver.findElement(By.name("employee_lastname")).sendKeys("Miranda");
//		driver.findElement(By.name("employee_middlename")).sendKeys("Vincent");
//		driver.findElement(By.name("branches_datefrom")).sendKeys("07/15/2013");
//		driver.findElement(By.name("branches_recentdate")).sendKeys("07/14/2022");
		
		WebElement dep = driver.findElement(By.name("employee_department"));
		Select s = new Select(dep);
		s.selectByVisibleText("Hiring Management");
		WebElement branch = driver.findElement(By.name("employee_branches"));
		Select s1 = new Select(branch);
		s1.selectByVisibleText("JP Nagar");
//		driver.findElement(By.name("employee_position")).sendKeys("Quality Assurance");
//		driver.findElement(By.name("employee_contact")).sendKeys("12345678907");
//		driver.findElement(By.name("employee_sss")).sendKeys("123456");
//		driver.findElement(By.name("employee_tin")).sendKeys("756985462");
//		driver.findElement(By.name("employee_hdmf_pagibig")).sendKeys("sadfasd");
//		driver.findElement(By.name("employee_gsis")).sendKeys("457896");
		driver.findElement(By.xpath("//button[.='Save']")).click();
		
		//driver.close();
		
		

	}

}
