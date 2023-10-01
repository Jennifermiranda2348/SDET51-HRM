package com.TestNG;

import org.testng.annotations.Test;

public class DPTest {
	@Test(dataProviderClass = DataFromExcelTest.class, dataProvider = "dataFromExcel")
	
	public void getData(String Brand,String Price, String RAMandROM, String Display)
	{
		System.out.println(Brand+"    "+Price+"    "+RAMandROM+"    "+Display);
	}

}
