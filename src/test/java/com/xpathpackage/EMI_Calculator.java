package com.xpathpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EMI_Calculator {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		WebElement node = driver.findElement(By.xpath("//*[name()='g' and @class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker']//*[@class='highcharts-point'][21]"));
		Actions a = new Actions(driver);
		a.moveToElement(node).perform();
		List<WebElement> allNodes = driver.findElements(By.xpath("//*[name()='g' and @class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker highcharts-series-hover']//*[contains(@class,'highcharts-point')]"));
		for (WebElement w : allNodes) {
			a.moveToElement(w).perform();
			List<WebElement> toolTip = driver.findElements(By.xpath("//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[contains(.,' ')]"));
			for (WebElement s : toolTip) {
				System.out.println(s.getText());
			}
			System.out.println("----------------------------");
		}
	driver.quit();
	}
}


