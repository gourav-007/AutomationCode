package com.seleneiumlearn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HandleWebTableData {

	public static void main(String[] args) {

		System.setProperty("webdriver.edge.driver", "C://msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://demo.guru99.com/test/table.html");
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i=0;i<rows.size();i++) {
			List <WebElement> cell = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cell.size();j++) {
				String str = cell.get(j).getText();
				System.out.println(str);
				
			}
				
		}
			driver.quit();
	}

}
