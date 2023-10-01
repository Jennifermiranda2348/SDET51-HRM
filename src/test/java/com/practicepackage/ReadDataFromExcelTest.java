package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Organisation");
		 
		int count = sh.getLastRowNum();
		 
		 for(int i=1; i<=count; i++)// fetch data from row
		 {
			 int lastcell = sh.getRow(i).getLastCellNum();
			 for(int j=0; j<lastcell; j++)//fetch data from column
			 {
				 String value = sh.getRow(i).getCell(j).getStringCellValue();
				 System.out.print(value+"   ");
			 }
			 System.out.println();
		 }
		
	}

}
