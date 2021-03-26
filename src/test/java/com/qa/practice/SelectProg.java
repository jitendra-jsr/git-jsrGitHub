package com.qa.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectProg {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.calculator.net/auto-loan-calculator.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		

		Select s = new Select(driver.findElement(By.xpath("//tbody/tr[6]/td[2]/select")));
		List<WebElement> e = s.getOptions();
		for(WebElement ee: e)
		{
			System.out.println(ee.getText());
			if(ee.getText().equals("Ohio"))
			{
				ee.click();
			}
		}
//		
//		System.out.println(e.size());
//	
//		for(int i=1;i<e.size();i++)
//		{
//			System.out.println(e.get(i).getText());
//			if(e.get(i).getText().contains("Ohio"))
//			{
//				e.get(i).click();
//			}
//		}
//		
		driver.close();
	}

}
