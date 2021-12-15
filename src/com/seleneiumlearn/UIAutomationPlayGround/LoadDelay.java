package com.seleneiumlearn.UIAutomationPlayGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadDelay {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://uitestingplayground.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[text()='Load Delay']")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement e = driver.findElement(By.xpath("//*[text()='Button Appearing After Delay']"));
		wait.until(ExpectedConditions.elementToBeClickable(e));
		System.out.println(e.getText());
		
		driver.close();
	}

}
