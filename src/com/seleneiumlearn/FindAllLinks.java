package com.seleneiumlearn;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FindAllLinks {

	//Collect all Links and Check with Broken Links.
	//Implementing Extends Reports.

	public static void main(String[] args) throws InterruptedException {

		ExtentReports er = new ExtentReports("BrokenLinkTest.html",false);
		ExtentTest et = er.startTest("Testing Broken Links");

		int respCode = 200;

		System.setProperty("webdriver.edge.driver", "C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()) {
			String url = it.next().getAttribute("href");
			System.out.println(url);

			try {
				HttpURLConnection huc = (HttpURLConnection)new URL(url).openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();

				respCode = huc.getResponseCode();
				
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
				TakesScreenshot tss = ((TakesScreenshot)driver);
				String filename = sdf.format(date)+".png";
				File src = tss.getScreenshotAs(OutputType.FILE);
				File dest = new File(filename);
				FileHandler.copy(src, dest);
				
				if(respCode >= 400){
					et.log(LogStatus.FAIL, "URL Link is broken."+et.addScreenCapture(filename));
				}
				else{
					et.log(LogStatus.PASS, "URL Link is Valid and Working");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			er.endTest(et);
			er.flush();

		}	
		System.out.println("Total Links I Iterate for you are : "+links.size());
		driver.close();


	}

}
