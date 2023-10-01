package com.xpathpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddiTest {

	public static void main(String[] args) {
		String teamname="Bengaluru Bulls";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		
		List<WebElement> teamnames = driver.findElements(By.xpath("//p[@class='name']"));
		for (WebElement team : teamnames) {
			if(team.getText().equalsIgnoreCase(teamname))
			{
				System.out.println("Position of team is ="+driver.findElement(By.xpath("(//p[.='"+team.getText()+"'])[1]/ancestor::div[@class='table-data team']/preceding-sibling::div/descendant::p[@class='position']")).getText());
				System.out.println("Total Matches played are ="+driver.findElement(By.xpath("(//p[.='"+teamname+"'])[1]/ancestor::div[@class='table-data team']/following-sibling::div[1]/child::p")).getText());
				System.out.println("Total Matches won are ="+driver.findElement(By.xpath("(//p[.='"+teamname+"'])[1]/ancestor::div[@class='table-data team']/following-sibling::div[2]/child::p")).getText());
				System.out.println("Total Matches Lost are ="+driver.findElement(By.xpath("(//p[.='"+teamname+"'])[1]/ancestor::div[@class='table-data team']/following-sibling::div[3]/child::p")).getText());
				System.out.println("Total Matches Tied are ="+driver.findElement(By.xpath("(//p[.='"+teamname+"'])[1]/ancestor::div[@class='table-data team']/following-sibling::div[4]/child::p")).getText());
			}
		} driver.close();
	}
}