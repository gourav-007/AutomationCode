package com.seleneiumlearn;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SetWindowSizeAndDimension {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C://edgedriver_win64 (1)//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		driver.manage().window().maximize();

		//Get size of window
		int h = driver.manage().window().getSize().height;
		int w = driver.manage().window().getSize().width;

		System.out.println(h+" "+w);
		//Change the size of browser
		Dimension d =new Dimension(500,500);
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get Position of Window
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();
		System.out.println("Position of Browser: "+x+" "+y);

		//Change position of browser

		Point p = new Point(873, 0);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		driver.close();

	}

}
