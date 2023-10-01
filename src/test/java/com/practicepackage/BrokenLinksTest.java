package com.practicepackage;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://ceg.karnataka.gov.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//Get all Links
		List<WebElement> listoflinks = driver.findElements(By.xpath("//a"));
		System.out.println(listoflinks.size());
		
		//Empty array
		ArrayList<String> link = new ArrayList<String>();
		
		for(int i=0;i<listoflinks.size();i++)
		{
			String eachlink = listoflinks.get(i).getAttribute("href");
			
			
			URL url = null;
			int statusCode = 0;
			
			try
			{
				url = new URL(eachlink);
				
				HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
				
				statusCode = httpsConn.getResponseCode();
				
				if(statusCode<=300)
				{
					link.add(eachlink);
					System.out.println(eachlink+ "  "+"----->" +statusCode);
				}
				
			}
			
		catch(Exception e)
		{
			link.add(eachlink);
		}
		
	
		}
	}
}