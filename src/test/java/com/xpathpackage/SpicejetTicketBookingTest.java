package com.xpathpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SpicejetTicketBookingTest {

	public static void main(String[] args) throws Throwable {
		//To handle notification popup in chrome
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");	
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//To click on round trip
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-zso239'])[2]")).click();
		Thread.sleep(3000);
		
		//to click on from
		driver.findElement(By.xpath("//div[text()='From']")).click();
		
		//to enter from place
		String from = "BLR";
		driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys(from);
		
		//to click on to
		driver.findElement(By.xpath("//div[text()='To']")).click();
		
		//to enter to place
		String to = "DEL";
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys(to);
		Thread.sleep(3000);				
				
		//to click on departure field
		driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		
		//to enter departure date
		String month = "September";
		int date = 30;
		driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(text(),'"+month+"')])[1]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and .='"+date+"']")).click();
		Thread.sleep(3000);
		
		//to click on return field
		driver.findElement(By.xpath("//div[text()='Return Date']")).click();	
				
		//Enter return date
		String month1 ="October";
		int date1 = 8;
		driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(text(),'"+month1+"')])[2]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and .='"+date1+"']")).click();
//		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(text(),'"+month1+"')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088' ]/descendant::div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and contains(text(),'"+date1+"')]")).click();
		Thread.sleep(3000);		
		
		
		driver.findElement(By.xpath("//div[text()='1 Adult']")).click();
		}

	}
