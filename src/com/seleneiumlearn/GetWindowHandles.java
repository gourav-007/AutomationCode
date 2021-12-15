package com.seleneiumlearn;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GetWindowHandles {

	static WebDriver driver;

	public static void setBrowser(String browser) {
		if(browser.equalsIgnoreCase("GC")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\edgedriver_win64 (1)\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}

	public static void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) {

		System.out.println("Enter recommended browser (GC/Edge) : ");
		Scanner sc = new Scanner(System.in);
		String browser = sc.next();
		GetWindowHandles.setBrowser(browser);

		driver.get("https://www.naukri.com/");
		String parentwindow = driver.getWindowHandle();
		Set<String> windowset = driver.getWindowHandles();
		Iterator<String> itr = windowset.iterator();
		while(itr.hasNext()) {
			String childwindow = itr.next();
			if(!parentwindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
			}

			else {
				driver.switchTo().window(parentwindow);
				System.out.println("Parent Window : "+parentwindow+" : "+driver.getTitle());
			}
		}

		GetWindowHandles.tearDown();
	}

}
