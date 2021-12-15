package com.seleneiumlearn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.edge.driver", "C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.makemytrip.com/");
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"langCardClose\"]"))).click();
		
		Actions a = new Actions(driver);
		WebElement doubleclick = driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));
		a.doubleClick(doubleclick).build().perform();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement bangpath = driver.findElement(By.xpath("//input[@type=\"text\" and @placeholder=\"From\"]"));
		bangpath.sendKeys("bang");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String xp = "//*[contains(@id,'react-autowhatever-1')]";
		List<WebElement> autosuggest = driver.findElements(By.xpath(xp));
		int count = autosuggest.size();
		System.out.println("No of Suggestions: "+count);
		System.out.println("Loading the suggestions....");
		for(int i=0;i<count;i++) {
			
			String autotext = autosuggest.get(i).getText();
			System.out.println(autotext);
		}
		
		bangpath.sendKeys(Keys.ARROW_DOWN);
		bangpath.sendKeys(Keys.ARROW_DOWN);
		bangpath.sendKeys(Keys.ENTER);
		
		driver.close();
				
	}

}
