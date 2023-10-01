package com.xpathpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonPhoneTest 
{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Phones");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement phones = driver.findElement(By.xpath("//div[@id='brandsRefinements']"));
		js.executeScript("window.scrollBy("+phones.getLocation().x+","+phones.getLocation().y+")");
		Thread.sleep(1500);
		WebElement sam = driver.findElement(By.xpath("//li[@id='p_89/Samsung']/descendant::label/descendant::i"));
		sam.click();
		int limit = 20000;
		
		List<WebElement> samphones = driver.findElements(By.xpath("(//span[@class='a-price-whole'][number(translate(text(),'₹,',''))<"+limit+"])/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/div/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole'][number(translate(text(),'₹,',''))<"+limit+"]"));
		
		for(int i = 0;i<samphones.size();i++)
		{
			System.out.print(samphones.get(i).getText()+"  ======>price is  "+prices.get(i).getText());
			System.out.println();
			
		}
		driver.close();

	}
	
	

}
