package com.seleneiumlearn;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportExample {

	public static void main(String[] args) {

		ExtentReports er = new ExtentReports("GoogleTest.html",false);
		ExtentTest et = er.startTest("Title for Test");

		//Get Site
		System.setProperty("webdriver.edge.driver", "C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//Get Title 
		String title = driver.getTitle();
		//Take Current Date and Time as File Name

		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String formatdate = sdf.format(date)+".png";
		//GetScreenShot
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		//SaveScreenShot
		File dest = new File(formatdate);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(title.equals("Google"))
		{
			et.log(LogStatus.PASS,"title is passed");
		}
		else {
			//attach screenshot to fail test cases in extent reports
			et.log(LogStatus.FAIL, "title not matched"+et.addScreenCapture(formatdate));
		}

		er.endTest(et);
		er.flush();
		driver.close();

	}

}
