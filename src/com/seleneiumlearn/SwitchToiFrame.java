package com.seleneiumlearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SwitchToiFrame {

	public static void main(String[] args) throws InterruptedException {
		//launch site
		
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://jqueryui.com/checkboxradio/");
		driver.manage().window().maximize();
		//switch to frame
		
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe[@class='demo-frame' or @src[start-with='/resources']]"));
		System.out.println("Frame Size: "+iframes);
		for(int i=0;i<iframes.size();i++) {
			driver.switchTo().frame(i);
			Thread.sleep(10000);
			System.out.println("Frame Number: "+i);
		}
		driver.findElement(By.xpath("//label[@for='radio-2']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='checkbox-3']")).click();
		Thread.sleep(5000);
		//backtopage
		driver.switchTo().defaultContent();
		driver.close();
	}

}
