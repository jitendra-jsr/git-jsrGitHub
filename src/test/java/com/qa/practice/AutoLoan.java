package com.qa.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoLoan {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.calculator.net/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// scroll page - JavascriptExecutor
		//method 1 - to a particular location
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		
		Thread.sleep(3000);
		
		//method 2 - to end of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(3000);
		
		//method 3 - scroll up
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		Thread.sleep(3000);
		
		// scroll page - Robot class
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		// scroll page - to a particular element
		WebElement we = driver.findElement(By.xpath("//a[contains(text(),'Auto Loan Calculator')]"));
		js.executeScript("arguments[0].scrollIntoView", we);
		System.out.println(we.getText());
		
		Thread.sleep(3000);
		
		//keys
		//WebElement ww = driver.findElement(By.xpath("//a[contains(text(),'BMI Calculator')]"));
		//ww.sendKeys(Keys.ENTER);
		
		we.sendKeys(Keys.ENTER);
		
		//enter the values
		driver.findElement(By.xpath("//input[@id='cloanamount']")).clear();
		driver.findElement(By.xpath("//input[@id='cloanamount']")).sendKeys("10000000");
		
		driver.findElement(By.xpath("//input[@id='cloanterm']")).clear();
		driver.findElement(By.xpath("//input[@id='cloanterm']")).sendKeys("150");
		
		driver.findElement(By.xpath("//input[@id='cinterestrate']")).clear();
		driver.findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys("10.5");
		
		driver.findElement(By.xpath("//input[@id='cdownpayment']")).clear();
		driver.findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys("100000");
		
		//Select  select = new Select();
		
		
		driver.findElement(By.xpath("//input[@id='csaletax']")).clear();
		driver.findElement(By.xpath("//input[@id='csaletax']")).sendKeys("0");
		
		driver.findElement(By.xpath("//input[@id='ctitlereg']")).clear();
		driver.findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys("0");
		
		driver.findElement(By.xpath("//tbody/tr[10]/td[1]/input[3]")).click();
		
		Thread.sleep(3000);
		
		//print the results
		String t1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[1]/td[1]")).getText();		
		String t2 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[1]/td[2]")).getText();
		
		System.out.println(t1+" : "+t2);
		
		String t3 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[2]/td[1]")).getText();		
		String t4 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[2]/td[2]")).getText();
		
		System.out.println(t3+" : "+t4);
		
		String t5 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[3]/td[1]")).getText();		
		String t6 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[3]/td[2]")).getText();
		
		System.out.println(t5+" : "+t6);
		
		String t7 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[4]/td[1]")).getText();		
		String t8 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[4]/td[2]")).getText();
		
		System.out.println(t7+" : "+t8);
		
		String t9 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[5]/td[1]")).getText();		
		String t10 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]//table//tbody//tr[5]/td[2]")).getText();
		
		System.out.println(t9+" : "+t10);
		
		
		
		
		
		
		
		
		
		
		
		driver.close();
	}

}
