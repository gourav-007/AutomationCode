package com.seleneiumlearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartTest {
	
	public static void main(String [] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String getTitle = driver.getTitle();
		System.out.println(getTitle);
		//driver.findElement(By.className("_2KpZ6l _2doB4z"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(getTitle));
		WebElement objele = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions actions = new Actions(driver);
		actions.moveToElement(objele).perform();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a")).click();
		String getnewTitle = driver.getTitle();
		System.out.println("New Title is:"+getnewTitle);
		driver.findElement(By.id("ap_customer_name")).sendKeys("Raja");
		driver.findElement(By.id("ap_phone_number")).sendKeys("9457869005");
		driver.findElement(By.id("ap_email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("abc@1234");
		Thread.sleep(5000);
		driver.close();
	
		
	
	}

}
