package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DualCalenderPopupTest {

	public static void main(String[] args) {
		
		String MonthAndYear = "October 2023";
		int Date = 21;
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//to close the login window in goibibo
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		//click on departure
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		//to find the actual date to choose
		String actual = "//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+Date+"'";
		
		
		//to click on next arrow to move to future months
		String nextArrow = "//span[@aria-label='Next Month']";
		
		//infinite loop to move next arrow for desired month 
		
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
		
		
		
		driver.quit();
	}

}
