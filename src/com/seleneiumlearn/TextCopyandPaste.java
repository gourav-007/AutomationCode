package com.seleneiumlearn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TextCopyandPaste {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.actitime.com/demo-request");
		WebElement v1 = driver.findElement(By.id("first-name"));
		v1.sendKeys("WebDriver");
		v1.sendKeys(Keys.CONTROL+"a");
		v1.sendKeys(Keys.CONTROL+"c");
		System.out.println(v1);
		WebElement v2 = driver.findElement(By.id("last-name"));
		v2.sendKeys(Keys.CONTROL+"v");
		System.out.println(v2);
		Thread.sleep(10000);
		driver.quit();
	}
}
