package com.seleneiumlearn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareExcelAndWebData{

	public static void main(String[]args) throws Exception {


		FileInputStream fis = new FileInputStream("C:\\Users\\gourav.c.jain\\Desktop\\excelassign.xlsx");
		XSSFWorkbook xwb = new XSSFWorkbook(fis);
		XSSFSheet xs = xwb.getSheetAt(0);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//table[@name='BookTable']//tbody"));
		List<WebElement> listele = driver.findElements(By.tagName("tr"));
		for(int i=0;i<listele.size();i++) {

			List<WebElement> weblist = listele.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<weblist.size();j++) {
				String str2 = weblist.get(j).getText();
				String str3 = xs.getRow(i).getCell(j).getStringCellValue();

				if(str2.equalsIgnoreCase(str3));
				{
					System.out.println("Matched");
					xs.getRow(i).createCell(4).setCellValue("Matched");
				}

			}
		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\gourav.c.jain\\Desktop\\excelassign.xlsx");
		xwb.write(fos);
		xwb.close();
		fos.close();
		fis.close();

		driver.close();
	}

}
