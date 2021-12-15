package com.seleneiumlearn;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class HighlightAndCaptureShot {

		public static void main(String[] args) throws Exception {
			System.setProperty("webdriver.chrome.driver", "C://Users//Training1.WIN-NFDCINOH1RK//Desktop//chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://testautomationpractice.blogspot.com");
			driver.manage().window().maximize();
			List<WebElement> textbox = driver.findElements(By.tagName("input"));
			System.out.println("Total Text Box Present outside the frame are: "+textbox.size());
			for(WebElement element:textbox) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(2000);
				js.executeScript("arguments[0].style.border='3px dashed red'", element);
				//Scroll to Bottom.
				
		}
			TakesScreenshot tss =  (TakesScreenshot)driver;
			File src = tss.getScreenshotAs(OutputType.FILE);
			File dest = new File("C://Users//Training1.WIN-NFDCINOH1RK//Desktop//WebPageShot.png");
			FileHandler.copy(src, dest);
		}
	}


}
