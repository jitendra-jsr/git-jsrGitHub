package com.qa.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelUtility {

	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private XSSFWorkbook wb;
	
	
	/**
	 * Create the xlxs read write object with file information
	 * 
	 * @param filepath
	 * @throws Exception 
	 * 
	 * **/
	
	public ReadWriteExcelUtility(String filePath) throws Exception
	{
		file = new File(filePath);
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		
	}
	
	/**
	 * get the row count of given sheet name this is not index based count it will return the actual row count
	 * 
	 * @param SheetName
	 * @throws rowIndex 
	 *  
	 * **/
	
	public int getRowCount(String SheetName)
	{
		XSSFSheet sheet = wb.getSheet(SheetName);
		// in case of wrong sheetname return 0
		if(sheet == null)
		{
			return 0;
		}
		return sheet.getLastRowNum();
	}
	
	/**
	 * get the cell count of a particular row  of the sheet
	 * 
	 * @param SheetName
	 * @throws rowIndex 
	 * @return cell count
	 * 
	 * **/
	
	public int getCellCount(String SheetName, int rowIndex)
	{
		XSSFSheet sheet = wb.getSheet(SheetName);
		// in case of wrong sheetname return 0
		if(sheet == null)
		{
			return 0;
		}
		
		XSSFRow row = sheet.getRow(rowIndex);
		if(row == null)
		{
			return 0;
		}
		
		return row.getLastCellNum();
	}
	
	
	/**
	 * return string cell value
	 * 
	 * @param SheetName
	 * @throws rowIndex 
	 * @return cell Index
	 * @return string cell value
	 * 
	 * **/
	
	public String getCellValue(String sheetName, int rowIndex, int cellIndex)
	{
		XSSFSheet sheet = wb.getSheet(sheetName);
		if(sheet == null)
		{
			return "sheet does not exist for sheetName" + sheetName;
		}
		
		XSSFRow row = sheet.getRow(rowIndex);
		if(row == null)
		{
			return "row does not exist for index" + rowIndex;
		}
		
		XSSFCell cell = row.getCell(cellIndex);
		if(cell == null)
		{
			return "cell does not exist for row index" + rowIndex +" and cell index " +cellIndex;
		}
		return cell.toString();
	}
	
	
	/**
	 * Write numeric value to the cell
	 * 
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @param value
	 * @throws IOException 
	 * @throws IoException
	 * 
	 * ***/
	
	public void writeNumericCellValue(String sheetName, int rowIndex, int cellIndex, double value) throws IOException
	{
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}

	/**
	 * Write Date value to the cell
	 * 
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @param value
	 * @throws IOException 
	 * 
	 * ***/
	
	public void writeDateCellValue(String sheetName, int rowIndex, int cellIndex, Date value) throws IOException
	{
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}


	/**
	 * Write Boolean value to the cell
	 * 
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @param value
	 * @throws IOException 
	 * 
	 * ***/
	
	public void writeBooleanCellValue(String sheetName, int rowIndex, int cellIndex, Boolean value) throws IOException
	{
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}
	
	/**
	 * Write String value to the cell
	 * 
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @param value
	 * @throws IOException 
	 * 
	 * ***/
	
	public void writeStringCellValue(String sheetName, int rowIndex, int cellIndex, String value) throws IOException
	{
		XSSFCell cell = getCell(sheetName, rowIndex, cellIndex);
		cell.setCellValue(value);
		write();
	}
	
	/**
	 * 
	 * Get cell object
	 * 
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @param return cell object
	 * 
	 * ***/
	
	private XSSFCell getCell(String sheetName, int rowIndex, int cellIndex) {
		XSSFSheet sheet = wb.getSheet(sheetName);
		if(sheet == null)
		{
			sheet = wb.createSheet(sheetName);
		}
		XSSFRow row = sheet.getRow(rowIndex);
		if(row == null)
		{
			row = sheet.createRow(rowIndex);
		}
		XSSFCell cell = row.getCell(cellIndex);
		if(cell == null)
		{
			cell = row.createCell(cellIndex);
		}
		return cell;
	}

	/**
	 * Write/save to excel file
	 * 
	 * @throws IOException
	 * ***/
	
	private void write() throws IOException 
	{
		fos = new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		
	}
	
}
