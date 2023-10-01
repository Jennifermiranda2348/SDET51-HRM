package com.xpathpackage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KayakFlightTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("d");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='flight-origin-smarty-input-list']//li//span[@class='JyN0-name']"));
		for (WebElement option : options) {
			if (option.getText().contains("New Delhi")) {
				option.click();
				break;
			}
		}
		// click to To
		driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).click();
		// click on dubai
		driver.findElement(By.xpath("//span[.='Dubai, United Arab Emirates']")).click();
		// click on calendar
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		// click on date
		driver.findElement(By.xpath("//div[@aria-label='Tuesday 10 October, 2023']")).click();
		// click om=n return date
		driver.findElement(By.xpath("//div[@aria-label='Tuesday 7 November, 2023']")).click();

		// click on search
		driver.findElement(By.xpath("//*[name()='svg' and @class='c8LPF-icon']")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentId = itr.next();
		String childId = itr.next();
		driver.switchTo().window(childId);
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='f8F1-price-text']"));
		for (WebElement price : prices) {
			System.out.println(price.getText());

		}

	}
}