package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CalenderPopupTest {

	public static void main(String[] args) {
		
		int date=31;
		
		//launch browser
		WebDriver driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//get URL
		driver.get("https://www.ksrtc.in/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//to click on date of departure
		driver.findElement(By.id("txtJourneyDate")).click();
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()='"+date+"']")).click();
		
		driver.quit();
		
		
		
		

	}

}
