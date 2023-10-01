package com.xpathpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EMI {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");
		WebElement point = driver.findElement(By.xpath("//*[@class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker']//*[@class='highcharts-point'][16]"));
		Actions a = new Actions(driver);
		a.moveToElement(point).perform();
		List<WebElement> allPOints = driver.findElements(By.xpath("//*[@class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker highcharts-series-hover']//*[contains(@class,'highcharts-point')]"));
		for (WebElement w : allPOints) {
			a.moveToElement(w).perform();
			List<WebElement> details = driver.findElements(By.xpath("//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']///*[contains(.,' ')]"));
			for (WebElement s : details) {
				System.out.println(s.getText());
			}
			System.out.println("----------------------------");
		}
	driver.quit();
	}
}