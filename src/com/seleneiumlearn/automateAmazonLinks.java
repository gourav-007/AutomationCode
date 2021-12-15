package com.seleneiumlearn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class automateAmazonLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverPath = "C://msedgedriver.exe";
		String key = "webdriver.edge.driver";
		System.setProperty(key, driverPath);
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Page Title is :"+title);
//		String newPageTitle = driver.getTitle();
//		System.out.println("PAGE TITLE: "+newPageTitle);
//		driver.navigate().back();
//		String oldPageTitle = driver.getTitle();
//		oldPageTitle.equals(title);
//		driver.close();
	}

}
