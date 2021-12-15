package com.seleneiumlearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutoCompleteSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");			
		driver.findElement(By.name("q")).sendKeys("Steve Jobs ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions ac = new Actions(driver);
		//Select 4th Cache
		for(int i=0;i<5;i++) {
			ac.sendKeys(Keys.DOWN).build().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		ac.sendKeys(Keys.ENTER).build().perform();
		driver.close();

			DesiredCapabilities i = DesiredCapabilities().edge();
			i.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			i.setCapability(EdgeOptions);
	}

}
