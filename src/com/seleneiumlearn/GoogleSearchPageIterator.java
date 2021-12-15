package com.seleneiumlearn;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPageIterator {

	public static void main(String[] args) {

		//Make Results File.
		int count=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word to search in Google.");
		String x = sc.next();
		System.setProperty("webdriver.edge.driver", "C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while(2>1) {
			wait.until(temp->js.executeScript("return document.readyState;").equals("complete"));
			//scroll down to last
			js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			//Go to next page.
			try {
				if(driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed());
				{
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					count++;
				}
			}
			catch(Exception ex) {
				System.out.println("I found "+count+" pages for your search "+x);
				break;
			}
		}
		driver.close();
	}
}


