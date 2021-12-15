package com.seleneiumlearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class VerifyAdminLoginPage_TC1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Verify Page Title
		if(driver.getTitle().equals("OrangeHRM")) {
			System.out.println("OrangeHRM Homepage Title is Displayed.");
		}

		//Verify UName,Password and Login Button displayed.

		WebElement objuname = driver.findElement(By.name("txtUsername"));
		WebElement objpwd = driver.findElement(By.name("txtPassword"));
		WebElement objlgnbtn = driver.findElement(By.name("Submit"));

		if((objuname.isDisplayed() & objpwd.isDisplayed() & objlgnbtn.isDisplayed())) {
			System.out.println("UN, PWD and LoginButton is available");
		}

		String uName = "Admin";
		String password = "admin123";
		objuname.clear();
		objuname.sendKeys(uName);
		objpwd.clear();
		objpwd.sendKeys(password);
		objlgnbtn.click();

		//Verify Admin Home Page

		String wText = driver.findElement(By.id("welcome")).getText();
		if(wText.equals("Welcome Sachin")) {
			System.out.println("Welcome Sachin is Displayed.");
		}

		Thread.sleep(5000);
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();

		//Verify Homeppage Title

		if(driver.getTitle().equals("OrangeHRM")) {
			System.out.println("Home Page Title is Displayed.");
		}

		driver.close();
		System.out.println("Close the browser.");
		driver.quit();
		System.out.println("Quit the Object.");

	}

}
