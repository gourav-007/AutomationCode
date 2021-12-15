package com.seleneiumlearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SwitchToActiveElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.way2sms.com/");
		driver.manage().window().maximize();
		driver.switchTo().activeElement().sendKeys("9630316647");
		Thread.sleep(10000);
		driver.close();
	}

}
