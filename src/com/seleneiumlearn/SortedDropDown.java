package com.seleneiumlearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortedDropDown {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement lists = driver.findElement(By.id("speed"));
		Select select = new Select(lists);
		List<WebElement> alloptions  = select.getOptions();
		
	
		
		
//		ArrayList<String> allText = new ArrayList<>();
//		for(int i=0;i<alloptions.size();i++) {
//			String listadd = alloptions.get(i).getText();
//			allText.add(listadd);
//		}
//		Collections.sort(allText);
//		{
//			for(String s:allText)
//			{
//				System.out.println(s);
//			}
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
