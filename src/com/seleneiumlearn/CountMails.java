package com.seleneiumlearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CountMails {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.gmail.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='identifierId' or @type='email']"))
		.sendKeys("iamsoumyajain@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='password' or @name='password']"))
		.sendKeys("Soumya@1234");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(10000);
		//Get no. of count mails in mails
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\":23\"]/tbody/"));
		int size = list.size();
		System.out.println("Size of List is: "+size);
		for(int i=0;i<size;i++) {
			List<WebElement> xlist = list.get(i).findElements(By.tagName("td"));
			int xsize = xlist.size();
			System.out.println("Count of Mails are: "+xsize);
		}
		//logout
		driver.findElement(By.xpath("//img[@id=\":1i\" or @aria-label='Google Account: Soumya Jain' ]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='gb_71' or text()='Sign Out']")).click();
		Thread.sleep(5000);
	}

}
