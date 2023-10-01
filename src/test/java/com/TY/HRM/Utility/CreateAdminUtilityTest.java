package com.TY.HRM.Utility;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebdriverUtility;

public class CreateAdminUtilityTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		//To fetch data from property file
		String BROWSER = fLib.getPropertyKeyValue("Browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username2");
		String PASSWORD = fLib.getPropertyKeyValue("password2");
				
		WebDriver driver = null;
				
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		wLib.maximizeTheBrowser(driver);
		
		driver.get(URL);
		wLib.implicitWait(driver, 10);
				
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		wLib.selectDropDown("→ HR Head", hrtype);
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
		wLib.acceptAlertPopup(driver);
		
		//To click on Admin link
		driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();
		
		//to click on Add admin
		driver.findElement(By.xpath("//p[.='Add Admin']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Admin')]")).click();
		
		//to enter all the mandatory field in Add employee fetching data from excel
		eLib.getRowCount("Admin");
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("Admin");
//		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = eLib.getMultipleDataFromExcel("Admin", 0, 1, driver);
//		HashMap<String,String> map= new HashMap<String,String>();
//		for(int i=0;i<count;i++)
//		{
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//		}
//		for(Entry<String,String> s:map.entrySet())
//		{
//			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
//		}
		
		//Enter valid data into mandatory field
//		driver.findElement(By.name("hr_companyid")).sendKeys("CONQ202301");
//		driver.findElement(By.name("hr_firstname")).sendKeys("Jennifer");
//		driver.findElement(By.name("hr_lastname")).sendKeys("Miranda");
//		driver.findElement(By.name("hr_middlename")).sendKeys("Vincent");
//		driver.findElement(By.name("hr_contactno")).sendKeys("15987432054");
		
		WebElement position = driver.findElement(By.id("hr_type"));
		wLib.selectDropDown("→ HR Officer", position);
		
//		Select sel1 = new Select(position);
//		sel1.selectByVisibleText();
		
//		driver.findElement(By.name("hr_email")).sendKeys("sa.empri@gmail.com");
//		driver.findElement(By.name("hr_password")).sendKeys("1234567");
		driver.findElement(By.xpath("//button[.='Save']")).click();
		wLib.acceptAlertPopup(driver);
		
		//Logout from HR Head
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
		wLib.acceptAlertPopup(driver);
		
		driver.close();
		
		
	}

}
