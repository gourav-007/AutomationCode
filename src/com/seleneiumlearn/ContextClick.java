package com.seleneiumlearn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.uitestingplayground.com/");
		WebElement e = driver.findElement(By.xpath("//*[text()='Mouse Over']"));

		Actions act = new Actions(driver);
		act.contextClick(e);
		act.sendKeys(Keys.ARROW_DOWN).click().build().perform();
		//		act.contextClick(e).sendKeys("w");		



	}

}
