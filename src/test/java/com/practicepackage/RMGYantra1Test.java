package com.practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantra1Test {

	public static void main(String[] args) throws Throwable {
		
		Connection con = null;
		ResultSet result = null;
		String projectname = "TY_HRM2023", projectmng = "Shridhar";
		
		try
		{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectname);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(projectmng);
		
		WebElement ele = driver.findElement(By.xpath("//select[@name='status']"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Driver driver1 = new Driver();
		
		DriverManager.registerDriver(driver1);
		
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		Statement state = con.createStatement();
		
		String query = "select * from project;";
		result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actual = result.getString(4);
			if(actual.equalsIgnoreCase(projectname))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("project is created");
		}
		else
		{
			System.out.println("project is not created");
		}
		}
		catch(Exception e)
		{}
		finally
		{
			con.close();
		}
	}

}
