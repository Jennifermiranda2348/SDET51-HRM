package com.xpathpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicsTableTest {

	public static void main(String[] args) {
		String countryName = "Austria";
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().window().maximize();
		List<WebElement> countryList=driver.findElements(By.xpath("//span[@data-cy='country-name']" ));
        for (int i = 0; i < countryList.size(); i++) {
			if (countryList.get(i).getText().equalsIgnoreCase(countryName)) {
				String goldMedal = driver.findElement(By.xpath("//div[@title='Gold']["+(i+1)+"]")).getText();
				String silverMedal = driver.findElement(By.xpath("//div[@title='Silver']["+(i+1)+"]")).getText();
				String bronzeMedal = driver.findElement(By.xpath("//div[@title='Bronze']["+(i+1)+"]")).getText();
				String totalCount = driver.findElement(By.xpath("//div[contains(@data-medal-id,'total-medals-row')]["+(i+1)+"]")).getText();
				System.out.println(countryName+" \nGoldMedal==> "+goldMedal+" \n"+"Silver Medal==> "+silverMedal+" \n"+"Bronze Medal ==> "+bronzeMedal
						+" \n"+"Total Medals==> "+totalCount+"\n");
				break;
			}
		}  
	}
}