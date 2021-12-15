package com.seleneiumlearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicButton {

	static WebDriver driver;
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[text()='Dynamic ID']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Dynamic ID")) {
			driver.findElement(By.xpath("//*[text()='Button with Dynamic ID']")).click();
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Class Attribute']")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 200);
//		driver.findElement(By.xpath("//button[contains(normalize-space(@class)), ' btn-primary ')]"));
//		wait.until(ExpectedConditions.alertIsPresent());
//		driver.switchTo().alert().accept();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Load Delay']")).click();
		String buttontext =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Button Appearing After Delay']"))).getText();
		System.out.println(buttontext);
		
		
		
	}

}
