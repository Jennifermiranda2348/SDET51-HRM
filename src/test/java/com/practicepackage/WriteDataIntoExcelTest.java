package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organisation");
		sh.createRow(12).createCell(0).setCellValue("TCS");
		sh.getRow(12).createCell(1).setCellValue("Bengaluru");
		sh.createRow(11).createCell(0).setCellValue("Monster1");
		sh.getRow(11).createCell(1).setCellValue("Haryana1");
		
		
		
		FileOutputStream fout = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fout);
		wb.close();
	}

}
