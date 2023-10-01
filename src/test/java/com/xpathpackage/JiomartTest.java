package com.xpathpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JiomartTest {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement groceries = driver.findElement(By.xpath("//a[.='Groceries']"));
		Actions a = new Actions(driver);
		a.moveToElement(groceries).perform();
		
		WebElement fandv = driver.findElement(By.xpath("//a[.='Fruits & Vegetables']"));
		
		a.moveToElement(fandv).perform();
		
		String values = driver.findElement(By.xpath("//ul[@class='header-nav-l3 custom-scrollbar']")).getText();
	
		System.out.println(values);
		
		driver.close();
	}

}
