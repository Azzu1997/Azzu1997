package com.ninza_hrm.utilityclasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excelutility 
{
	public String readSingleDataFromEXcel(String SheetName,int rowNo,int cellNo) throws  IOException {
		FileInputStream fi = new FileInputStream("path");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		 String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}


	public ArrayList<String> readMultipleDataFromExcel(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream("path");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("SheetName");
		int rowCount = sh.getLastRowNum();
		short celCount = sh.getRow(0).getLastCellNum();    
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<=rowCount;i++)
		{
				for(int j=0;j<celCount;j++)
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		return list;
			}
	
public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi = new FileInputStream("path");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	
public int getCelCount(String SheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi = new FileInputStream("path");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		 int celCount = sh.getRow(0).getLastCellNum();
		 return celCount;
		 }

public void writeDataFromExcel(String SheetName,String value) throws EncryptedDocumentException, IOException {
	FileInputStream fi = new FileInputStream("path");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	Row row = sh.getRow(0);
	Cell cel = row.createCell(0);
	//cel.setCellType(CellType.STRING);//deprecated
	cel.setCellValue(value);
	
	FileOutputStream fo = new FileOutputStream("path");
	wb.write(fo);
	wb.close();
	
}


public Object[][] ReadMutipleSetOfData(String Sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream file = new FileInputStream("./src/test/resources/TP30.xls");
	Workbook wb = WorkbookFactory.create(file);
	Sheet sh = wb.getSheet("Dataprovider");
	int rowCount = sh.getLastRowNum();
	int celcount = sh.getRow(0).getLastCellNum();
	
	//Array to print all 
	Object[][] obj = new  Object[rowCount][celcount];
	
	//FOr rows
	for(int i=0; i<=rowCount; i++)
	{
		for(int j=0; j<celcount; j++)
		{
		obj[i][j]	=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}
}



