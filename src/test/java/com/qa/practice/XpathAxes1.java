package com.qa.practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\driver88\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/weekly/groupz");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//self
		WebElement self=driver.findElement(By.xpath("//a[contains(text(),'Boston Leasing')]/self::a"));	
		System.out.println("Self axes: "+self.getText());
		
		//parent
		WebElement parent=driver.findElement(By.xpath("//a[contains(text(),'Boston Leasing')]/parent::td"));	
		System.out.println("parent axes: "+parent.getText());
		
		//parent
		WebElement anscestor=driver.findElement(By.xpath("//a[contains(text(),'Boston Leasing')]/ancestor::tr"));	
		System.out.println("anscestor axes: "+anscestor.getText());
		
		//preceeding siblings
		List<WebElement> preceding=driver.findElements(By.xpath("//a[contains(text(),'Boston Leasing')]/parent::td/preceding::tr"));
		Iterator<WebElement> itr = preceding.iterator();
		while(itr.hasNext()) {
			WebElement we = itr.next();
		System.out.println("preceding axes: "+we.getText());
		}
		
		//descendant
		List<WebElement> desc =driver.findElements(By.xpath("//a[contains(text(),'Boston Leasing')]/parent::td/parent::tr/descendant::td"));
		for(int i=0;i<desc.size();i++)
		{
			System.out.println("Descendant :"+desc.get(i).getText());
		}
		
		//following siblings
		List<WebElement> followsib =driver.findElements(By.xpath("//a[contains(text(),'Boston Leasing')]/parent::td/parent::tr/following-sibling::tr"));
		Iterator<WebElement> it = followsib.iterator();
		while(it.hasNext())
		{
			WebElement ww = it.next();
			System.out.println("following siblings : "+ww.getText());
		}
		
		
		
		
		driver.close();
	}

}
