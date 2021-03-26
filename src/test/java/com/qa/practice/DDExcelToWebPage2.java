package com.qa.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDExcelToWebPage2 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.communityspirit.bank/online-services/loan-calculator");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//loan amount
		WebElement la = driver.findElement(By.xpath("//input[@name='loan']"));
		
		//months
		WebElement mon = driver.findElement(By.xpath("//input[@name='months']"));
		
		//interest rate
		WebElement ir = driver.findElement(By.xpath("//input[@name='rate']"));
		
		//calculate button
		WebElement calButton = driver.findElement(By.xpath("//input[@type='button']"));
		
		//reset button
		WebElement resetButton = driver.findElement(By.xpath("//input[@type='reset']"));
		
		//create excel utility object with file path
		ReadWriteExcelUtility rw = new ReadWriteExcelUtility("C:\\Users\\win8\\Desktop\\BMI.xlsx");
		
		//sheet name
		String sheetName = "Sheet1";
		
		//get row count
		int rowCount = rw.getRowCount(sheetName);
		System.out.println("Row count: "+rowCount);
		
		// for every row get cell value and send it to input box
		for(int i=1;i<=rowCount;i++)
		{
			String loanAmt = rw.getCellValue(sheetName, i, 8);
			la.sendKeys(loanAmt);
			
			String month = rw.getCellValue(sheetName, i, 9);
			mon.sendKeys(month);
			
			String interest = rw.getCellValue(sheetName, i, 10);
			ir.sendKeys(interest);
			
			calButton.click();
			Thread.sleep(2000);
			
			/**
			 * Write data to excel sheet
			 * **/
			WebElement emi = driver.findElement(By.xpath("//input[@name='pay']"));
			String emiStringValue = emi.getAttribute("value");
			rw.writeStringCellValue(sheetName, i, 11, emiStringValue);
			
			Thread.sleep(2000);
			
			
			resetButton.click();
		}
		
		
		
		driver.close(); 
		}
		
		
		
		
	}


