package com.seleneiumlearn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateSheetAndCopyValues {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.c.jain\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\gourav.c.jain\\Desktop\\excelassign.xlsx");
		XSSFWorkbook xwb = new XSSFWorkbook(fis);
		XSSFSheet xs = xwb.getSheetAt(0);
		String sheetname = "CopySheet";
		System.out.println(xs.getPhysicalNumberOfRows());
		
		xwb.createSheet(sheetname);
		XSSFSheet xs1 = xwb.getSheet(sheetname);
		System.out.println(xs1.getRow(0).getCell(0).getStringCellValue());

		
//		for(int i=0;i<xs.getPhysicalNumberOfRows();i++) {
//			xs1.createRow(i);
//			
//			for(int j=0;j<=xs.getRow(0).getPhysicalNumberOfCells();j++) {
//				xs1.getRow(0).createCell(0).setCellValue(xs.getRow(0).getCell(0).getStringCellValue());
//			}
//		}
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\gourav.c.jain\\Desktop\\excelassign.xlsx");
		xwb.write(fos);
		xwb.close();
		fos.close();
		fis.close();
		driver.close();
	}

}
