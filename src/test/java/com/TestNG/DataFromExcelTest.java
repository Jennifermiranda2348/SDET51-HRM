package com.TestNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.IPathconstants;

public class DataFromExcelTest {
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.getMultipleSetOfData("DP");
		return value;
	}

}
