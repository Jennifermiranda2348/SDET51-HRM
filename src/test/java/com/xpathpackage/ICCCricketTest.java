package com.xpathpackage;

import java.time.Duration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class ICCCricketTest {

	public static void main(String[] args) {
		
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			
			List<WebElement> matches = driver.findElements(By.xpath("//span[@class='u-hide-ph ablet']/../following-sibling::td[@class='table-body__cell u-center-text' and text()<40 or @class='rankings-block__banner--matches' and text()<40]"));
			List<WebElement> pos=driver.findElements(By.xpath("//tbody/tr/td[1]"));
			for (WebElement team : matches) {
				System.out.println(team.getText());
				driver.findElements(By.xpath("//tbody/child::tr"));
				
			}
			for (WebElement country : pos) {
				System.out.println(driver.findElement(By.xpath("//td[.='"+country.getText()+"' or @class='u-hide-phablet']/..//td[2]")).getText());
			}
			
	}

}
