package com.qa.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDExcelToWebPage1 {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://karvitt.com/widgets/html-code/emi-calculator");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//loan amt inputbox
		WebElement loanAmount = driver.findElement(By.xpath("//input[@id='loan1']"));
		
		//loan Tenure in months
		WebElement months = driver.findElement(By.xpath("//input[@id='months1']"));
		
		//loan rate of interest
		WebElement interestRate = driver.findElement(By.xpath("//input[@id='rate1']"));
		
		//submit button
		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		
		//reset button
		WebElement resetButton = driver.findElement(By.xpath("//button[contains(text(),'Reset')]"));
		
		//create excel utility object with file path
		ReadWriteExcelUtility xl = new ReadWriteExcelUtility("C:\\Users\\win8\\Desktop\\BMI.xlsx");
		
		//sheet name
		String sheetName = "Sheet1";
		
		//get row count
		int rowCount = xl.getRowCount(sheetName);
		System.out.println("Row count: "+rowCount);
		
		// for every row get cell value and send it to input box
		for(int i=1; i<=rowCount; i++)
		{
			String loanAmt = xl.getCellValue(sheetName, i, 0);
			loanAmount.sendKeys(loanAmt);
			
			String month = xl.getCellValue(sheetName, i, 1);
			months.sendKeys(month);
			
			String interest = xl.getCellValue(sheetName, i, 2);
			interestRate.sendKeys(interest);
			
			submitButton.click();
			Thread.sleep(2000);
			
			/**
			 * Write data to excel sheet
			 * **/
			WebElement emi = driver.findElement(By.xpath("//input[@id='pay1']"));
			String emiStringValue = emi.getAttribute("value");
			xl.writeStringCellValue(sheetName, i, 4, emiStringValue);
			
			WebElement interestPayable = driver.findElement(By.xpath("//input[@id='tintt1']"));
			String intPayable = interestPayable.getAttribute("value");
			xl.writeStringCellValue(sheetName, i, 5, intPayable);
			
			WebElement totalPayable = driver.findElement(By.xpath("//input[@id='gt1']"));
			String totPayable = totalPayable.getAttribute("value");
			
			xl.writeStringCellValue(sheetName, i, 6, totPayable);
			Thread.sleep(2000);
			
			
			resetButton.click();
		}
		
		
		
		driver.close();
	}

}
