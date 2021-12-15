package com.seleneiumlearn.UIAutomationPlayGround;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class AJAXCalls {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		List<WebElement> textbox = driver.findElements(By.tagName("input"));
		System.out.println(textbox.size());
		for(WebElement element:textbox) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(2000);
			js.executeScript("arguments[0].style.border='3px dashed red'", element);
		}
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\webshot.png");
		FileHandler.copy(src, dest);
	}

}
