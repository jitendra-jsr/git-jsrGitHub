package com.qa.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelLoan {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.calculator.net/interest-calculator.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement prin = driver.findElement(By.id("cstartingprinciple"));
		
		
	}

}
