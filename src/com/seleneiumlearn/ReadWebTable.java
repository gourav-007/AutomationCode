package com.seleneiumlearn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadWebTable{

	public static void main(String[]args) throws Exception {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("C:\\Users\\gourav.c.jain\\Desktop\\excelassign.xlsx");
		XSSFWorkbook xbk = new XSSFWorkbook(fis);
		XSSFSheet xws = xbk.getSheetAt(0);
		WebElement e = driver.findElement(By.xpath("//table[@name='BookTable']//tbody"));


		List<WebElement> row = driver.findElements(By.tagName("tr"));
		System.out.println(row.size());
		for(int i=0;i<row.size();i++) {
			List<WebElement> coll =  row.get(i).findElements(By.tagName("td"));
			xws.createRow(i);
			for(int j=0;j<coll.size();j++) {
				String str = coll.get(j).getText();
				xws.getRow(i).createCell(j).setCellValue(str);
				System.out.println(str);
			}
			//			xws.createRow(sizeOfList).createCell(i).setCellValue(liste.get(i).getText());
		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\gourav.c.jain\\Desktop\\excelassign.xlsx");
		xbk.write(fos);
		xbk.close();
		fos.close();
		fis.close();
		
		driver.close();
	}

}
