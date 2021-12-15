package com.seleneiumlearn.UIAutomationPlayGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColorChangingButton {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		
		driver.get("http://uitestingplayground.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Hidden Layers']")).click();
		
		//Get color change from Green to Blue.
		
		WebElement button = driver.findElement(By.xpath("//*[@id=\"greenButton\"]"));
		System.out.println("Before Click : "+button.getCssValue("background-color"));
		if(button.isDisplayed()) {
			if(button.isEnabled()) {
				WebDriverWait wait = new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable(button));
				button.click();
				WebElement e = driver.findElement(By.xpath("//*[@id=\"blueButton\"]"));
				wait.until(ExpectedConditions.visibilityOf(e));
				System.out.println("After Click Color : "+e.getCssValue("background-color"));
			}
		}
		driver.close();
	}

}
