package com.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider = "mobiles")
	
	public void getData(String Brand,int Price, String RAMandROM, String Display)
	{
		System.out.println(Brand+"    "+Price+"    "+RAMandROM+"    "+Display);
	}
	
	@DataProvider
	public Object[][] mobiles()
	{
		Object[][] obj = new Object[4][4];
		
		obj[0][0] = "Samsung";
		obj[0][1] = 15000;
		obj[0][2] = "4GB  64GB";
		obj[0][3] = "4.5 inch";
		
		obj[1][0] = "One+";
		obj[1][1] = 25000;
		obj[1][2] = "6GB 128GB";
		obj[1][3] = "5.4 inch";
		
		obj[2][0] = "Vivo";
		obj[2][1] = 20000;
		obj[2][2] = "4GB 256GB";
		obj[2][3] = "5.6 inch";
		
		obj[3][0] = "iPhone";
		obj[3][1] = 60000;
		obj[3][2] = "RAM 4GB 32GB";
		obj[3][3] = "5.4 inch";
		
		return obj;
	}
	
	}
