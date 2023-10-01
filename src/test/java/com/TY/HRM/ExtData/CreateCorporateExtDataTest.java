package com.TY.HRM.ExtData;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateCorporateExtDataTest {

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
		
		//To click on corporate link
		driver.findElement(By.xpath("//i[@class='nav-icon fa fa-handshake']")).click();
		
		//To click on add corporate
		driver.findElement(By.xpath("//p[.='Add Corporate']")).click();
		driver.findElement(By.xpath("//h3[@class='card-title']")).click();
		
		String corpname = "Conquister";
		//Enter corporate name
		driver.findElement(By.name("corporate_name")).sendKeys(corpname);
		driver.findElement(By.xpath("//button[.='Save']")).click();
		a.accept();
		
		driver.close();
		
	}

}
