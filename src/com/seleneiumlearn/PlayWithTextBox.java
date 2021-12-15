package com.seleneiumlearn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PlayWithTextBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		/*Below we are finding element textbox and sending keys
		 * and Selecting that text and doing Cut and Sending anothod phrase
		 * to the same element.
		 */
		
		driver.get("https://www.actitime.com/demo-request");
		WebElement printvalue = driver.findElement(By.id("first-name"));
		printvalue.sendKeys("WebDriver");
		printvalue.sendKeys(Keys.CONTROL+"a");
		printvalue.sendKeys(Keys.CONTROL+"x");
		printvalue.sendKeys("FullDriver");
		//		printvalue.sendKeys(Keys.TAB);
		//		driver.findElement(By.id("last-name"));		
		//		printvalue.sendKeys(Keys.CONTROL+"v");
		
		/* TO CLEAR THE TEXT WITHIN TEXTBOX USING BACKSPACE */
		
		String a = printvalue.getAttribute("value");
		int count = a.length();
		for(int i=0;i<=count;i++) {
			printvalue.sendKeys(Keys.BACK_SPACE);
			System.out.println(printvalue);

		}
	}

}
