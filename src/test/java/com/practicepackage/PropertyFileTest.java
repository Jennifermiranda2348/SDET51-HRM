package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {
	
		//Step 1:Object representation of property file
		FileInputStream fis= new FileInputStream("./src/test/resources/CommanData.properties");
		
		//Step 2: Object to property file
		Properties pro = new Properties();
		
		//Step 3: load the keys
		pro.load(fis);
		
		//Step 4: Use getProperty to fetch the value
		String BROWSER = pro.getProperty("Browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println();
		System.out.println(URL);
		System.out.println();
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println();
		
		
		String USERNAME1 = pro.getProperty("username1");
		String PASSWORD1 = pro.getProperty("password1");
		
		System.out.println(USERNAME1);
		System.out.println(PASSWORD1);
		System.out.println();
		
		String USERNAME2 = pro.getProperty("username2");
		String PASSWORD2 = pro.getProperty("password2");
		
		System.out.println(USERNAME2);
		System.out.println(PASSWORD2);
		System.out.println();
	}
	

}
