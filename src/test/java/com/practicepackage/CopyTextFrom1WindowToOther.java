package com.practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CopyTextFrom1WindowToOther {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
//		String firstWindow = driver.getWindowHandle();
		String fontColor = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).getCssValue("color");
		String fontColorHex = rgbHexa(fontColor);
		System.out.println("Font Color in Hexadecimal: " + fontColorHex);
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



//        WebElement sourceElement = driver.findElement(By.id("sourceElementId"));
//        String copiedText = sourceElement.getText();
//
//        // Open the second window
//        // You can simulate opening a new window, e.g., by opening a new URL or a new tab
//        // and then switch to it
//
//        // Switch to the second window
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(firstWindowHandle)) {
//                driver.switchTo().window(windowHandle);
//            }
//        }
//
//        // Locate the input field in the second window (e.g., using a WebElement)
//        WebElement targetElement = driver.findElement(By.id("targetElementId"));
//
//        // Paste the copied text into the input field
//        Actions actions = new Actions(driver);
//        actions.moveToElement(targetElement).click().sendKeys(copiedText).perform();
//
//        // Close the browser
//        driver.quit();
//    }
//}
