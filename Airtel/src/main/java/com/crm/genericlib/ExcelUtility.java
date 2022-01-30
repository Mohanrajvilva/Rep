package com.crm.genericlib;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getdatafromexcel(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fs=new FileInputStream(Autoconstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell col=row.getCell(cellnum);
		String data = col.getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getrowcount(String sheetname) throws Throwable
	{
		FileInputStream fs=new FileInputStream(Autoconstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet(sheetname);
		return sh.getLastRowNum();
	}
	public void setdatatoexcel(String sheetname,int rownum,int cellnum,String data) throws Throwable
	{
		FileInputStream fs=new FileInputStream(Autoconstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet(sheetname);
		Row row=sh.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(Autoconstant.Excelfilepath);
		wb.write(fos);
		wb.close();
	}

}
