package com.TY.HRM.ExtData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAdminExtDataTest {

	public static void main(String[] args) throws Throwable {
		//To fetch data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
		Properties pro = new Properties();
		pro.load(fis);
				
		String BROWSER = pro.getProperty("Browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username2");
		String PASSWORD = pro.getProperty("password2");
				
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
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement hrtype = driver.findElement(By.id("hr_type"));
		Select sel = new Select(hrtype);
		sel.selectByVisibleText("→ HR Head");
		driver.findElement(By.name("login_hr")).click();
		
		//To handle alter pop up 
		Alert a = driver.switchTo().alert();
		a.accept();
		
		//To click on Admin link
		driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();
		
		//to click on Add admin
		driver.findElement(By.xpath("//p[.='Add Admin']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Admin')]")).click();
		
		//to enter all the mandatory field in Add employee fetching data from excel
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Admin");
		int count = sh.getLastRowNum();
		
		
		HashMap<String,String> map= new HashMap<String,String>();
		for(int i=0;i<count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String,String> s:map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
		//Enter valid data into mandatory field
//		driver.findElement(By.name("hr_companyid")).sendKeys("CONQ202301");
//		driver.findElement(By.name("hr_firstname")).sendKeys("Jennifer");
//		driver.findElement(By.name("hr_lastname")).sendKeys("Miranda");
//		driver.findElement(By.name("hr_middlename")).sendKeys("Vincent");
//		driver.findElement(By.name("hr_contactno")).sendKeys("15987432054");
		
		WebElement position = driver.findElement(By.id("hr_type"));
		Select sel1 = new Select(position);
		sel1.selectByVisibleText("→ HR Officer");
		
//		driver.findElement(By.name("hr_email")).sendKeys("sa.empri@gmail.com");
//		driver.findElement(By.name("hr_password")).sendKeys("1234567");
		driver.findElement(By.xpath("//button[.='Save']")).click();
		a.accept();
		
		//Logout from HR Head
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
		a.accept();
		
		driver.close();
		
		
	}

}
