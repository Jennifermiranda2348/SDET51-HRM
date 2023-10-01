package com.TY.HRM.Hardcode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAdminTest {

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
		
		//To click on Admin link
		driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();
		
		//to click on Add admin
		driver.findElement(By.xpath("//p[.='Add Admin']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Admin')]")).click();
		
		
		//Enter valid data into mandatory field
		driver.findElement(By.name("hr_companyid")).sendKeys("CONQ202301");
		driver.findElement(By.name("hr_firstname")).sendKeys("Jennifer");
		driver.findElement(By.name("hr_lastname")).sendKeys("Miranda");
		driver.findElement(By.name("hr_middlename")).sendKeys("Vincent");
		driver.findElement(By.name("hr_contactno")).sendKeys("15987432054");
		
		WebElement position = driver.findElement(By.id("hr_type"));
		Select sel1 = new Select(position);
		sel1.selectByVisibleText("→ HR Officer");
		
		driver.findElement(By.name("hr_email")).sendKeys("sa.empri@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("1234567");
		driver.findElement(By.xpath("//button[.='Save']")).click();
		a.accept();
		
		//Logout from HR Head
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
		a.accept();
		
		driver.close();
		
		
	}

}
