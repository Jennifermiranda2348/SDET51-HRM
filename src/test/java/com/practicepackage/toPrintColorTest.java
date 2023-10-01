package com.practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class toPrintColorTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
//		String firstWindow = driver.getWindowHandle();
		String fontColor = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).getCssValue("color");
		String fontColorHex = rgbHexa(fontColor);
		System.out.println("Font Color in Hexadecimal: " +fontColorHex);
		driver.quit();
	}	
		public static String rgbHexa(String rgb)
		{
			String[] rgbValues = rgb.replace("rgba(","").replace(")","").split(",");
		
//			String HexaColor = rgbToHex(fontColor);
//			System.out.println(HexaColor);
			int r = Integer.parseInt(rgbValues[0].trim());
			int g = Integer.parseInt(rgbValues[1].trim());
			int b = Integer.parseInt(rgbValues[2].trim());
		
			String hex = String.format("#%02X%02X%02X",r,g,b);
			return hex;
		
		}
	}