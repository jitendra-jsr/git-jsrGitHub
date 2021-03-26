package com.qa.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("selenium testing");
		
		List<WebElement> mylist =driver.findElements(By.xpath("//ul[@class='erkvQe' and @role='listbox']//li"));
		for(int i=0;i<mylist.size();i++)
		{
			//System.out.println(mylist.get(i).getText());
		}
		
		System.out.println("**************************");
		
		//self
		WebElement self = driver.findElement(By.xpath("//ul[@class='erkvQe' and @role='listbox']//li[5]/self::li"));		
		System.out.println("Self axes: "+self.getText());
		
		//following
//		List<WebElement> following = driver.findElements(By.xpath("//ul[@class='erkvQe' and @role='listbox']//li[5]/following::li"));		
//		for(WebElement ff: following) {
//			System.out.println("following axes: "+ff.getText());
//		}		
//		
		//ancestor
		List<WebElement> parent = driver.findElements(By.xpath("//ul[@class='erkvQe' and @role='listbox']//li[5]/ancestor::ul"));		
		for(WebElement ff: parent) {
		System.out.println("parent axes: "+ff.getText());
		}

		//self
		WebElement parentaxes = driver.findElement(By.xpath("//ul[@class='erkvQe' and @role='listbox']//li[5]/parent::ul"));		
		System.out.println("parent axes: "+parentaxes.getText());

		//preceding-sibling
		List<WebElement> precedingsibling = driver.findElements(By.xpath("//ul[@class='erkvQe' and @role='listbox']//li[5]/preceding-sibling::li"));		
		for(WebElement ff: precedingsibling) {
		System.out.println("preceding-sibling axes: "+ff.getText());
		}

		//preceding-sibling
		List<WebElement> followingsibling = driver.findElements(By.xpath("//ul[@class='erkvQe' and @role='listbox']//li[5]/following-sibling::li"));		
		for(WebElement ff: followingsibling) {
		System.out.println("following-sibling axes: "+ff.getText());
		}
		
		driver.close();
	}

}
