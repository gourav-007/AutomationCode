package com.seleneiumlearn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AutomateBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver","C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
//		//Open the browser
//		driver.get("https://www.google.co.in");
//		
//		//ReSize the Browser
//		Dimension dim = new Dimension(200, 200);
//		driver.manage().window().setSize(dim);
//
//		//Move the Browser
//		Point p = new Point(500, 500);
//		driver.manage().window().setPosition(p);
//		
//		//Maximize the Browser
//		
//		driver.manage().window().maximize();
		
		RemoteWebDriver rwd = (RemoteWebDriver) driver;
		
		
		
		

	}

}
