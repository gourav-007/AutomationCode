package com.seleneiumlearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testPage {

			public static void main(String[] args) {
				System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
				WebDriver driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.google.com");
				String e = driver.getTitle();
				if(e.equals("Google"))
				{
					System.out.println("Pass: Title is "+e);
				}
				else {
					System.out.println("Fail: Actual Title is "+e);
				}

				String url = driver.getCurrentUrl();
				if(url.contains("google.co.in"))
				{
					System.out.println("PASS: URL has .co.in");
				}
				else
				{
					System.out.println("FAIL: url has donsn't have .co.in "+url);
					}
						

				}

			}
