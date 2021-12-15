package com.seleneiumlearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AutomationSampleTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println(driver.manage().getCookies().size());
		
		WebElement src = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement desc = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(src, desc);
		String text = "Dropped!";
		if(text.equals("Dropped")) {
			System.out.println("Test Passed...Hence closing the browser");
		}
		else {
			System.out.println("Test Case not passed.");
			int x = driver.manage().window().getSize().getHeight();
			int y = driver.manage().window().getSize().getWidth();
			//Set Size
			Dimension d = new Dimension(500, 500);
			driver.manage().window().setSize(d);
			
			//Set Size
			
			int a = driver.manage().window().getPosition().getX();
			int b = driver.manage().window().getPosition().getY();
			
			//Set Position
			Point p = new Point(873,0);
			driver.manage().window().setPosition(p);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(5000);
		}

	}

}
