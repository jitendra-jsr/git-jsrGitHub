package com.qa.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelData {

	public static void main(String[] args) throws IOException {
	
		ReadingExcelData re = new ReadingExcelData();
		String ff= "C:\\Users\\win8\\Desktop\\cricketers.xlsx";
		re.readExcel(ff, "cricketers.xlsx", "Sheet1");
		
	}
	
	public void readExcel(String filePath, String fileName, String sheetName) throws IOException
	{
		File file = new File(filePath);
		
		FileInputStream fis = new FileInputStream(file);
	
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh = wb.getSheetAt(0);
		
		Iterator<Row> rowIterator = sh.iterator();
		
		while(rowIterator.hasNext())
		{
			Row row = rowIterator.next();
			
			Iterator<Cell> cellIterator = row.iterator();
			
			Cell cell = cellIterator.next();
			
			switch(cell.getCellType())
			{
//			case STRING:
//				System.out.print(cell.getStringCellValue()+"\t");
//				break;
//			case INTEGER:
//				System.out.print(cell.getNumericCellValue()+"\t");
//				break;
//			case BOOLEAN:
//				System.out.print(cell.getBooleanCellValue()+"\t");
//				break;
			}
		}
		System.out.println();
	}

}
