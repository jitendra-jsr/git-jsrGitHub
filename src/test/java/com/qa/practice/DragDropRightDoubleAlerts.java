package com.qa.practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropRightDoubleAlerts {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Right click in the TextBox
		Actions action = new Actions(driver);
		WebElement link = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		action.contextClick(link).build().perform();
		
		driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']/descendant::li[3]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(3000);

		//double click
		WebElement doubles = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
		action.doubleClick(doubles).perform();
		System.out.println(alert.getText());
		
		alert.accept();
		
		//screen shot
				TakesScreenshot st = (TakesScreenshot) driver;
				File scrfile = st.getScreenshotAs(OutputType.FILE);
				File dest = new File("C:\\Users\\win8\\Desktop\\screenshots.png");
				FileUtils.copyFile(scrfile, dest);
				
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
