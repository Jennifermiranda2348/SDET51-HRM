package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTripTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		Actions a = new Actions(driver);
		a.doubleClick().perform();
		
		Thread.sleep(1000);		
		
		a.moveByOffset(0,80).click().perform();
		Thread.sleep(1000);
		
		//To click on Departure dropdown
		
		//driver.findElement(By.xpath("//span[@class='lbl_input appendBottom10']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		
		
	
	
		
		
	}

}
