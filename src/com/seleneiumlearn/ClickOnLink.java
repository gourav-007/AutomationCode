package com.seleneiumlearn;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnLink {
	
	//Q. How to get count of all links in a webpage and click on it.?

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<=links.size();i++) {
			links.get(i).click();
			String parentid = driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
			Iterator<String> itr = child.iterator();
			if(itr.hasNext()) {
				driver.switchTo().window(itr.next());
			}
		}
		
	}

}
