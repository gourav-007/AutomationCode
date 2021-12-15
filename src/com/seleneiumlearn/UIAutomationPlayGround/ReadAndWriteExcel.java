package com.seleneiumlearn.UIAutomationPlayGround;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcel {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\gourav.c.jain\\Desktop\\randomdatafordelete.xlsx");
		XSSFWorkbook xb;
		XSSFSheet xs;
		XSSFCellStyle cellstyle;
		XSSFColor color = new XSSFColor(new java.awt.Color(43,150,150), null);

		try {
			FileInputStream fis = new FileInputStream(file);
			xb = new XSSFWorkbook(fis);
			xs = xb.getSheetAt(0);
			cellstyle = xb.createCellStyle();
			cellstyle.setFillBackgroundColor(color);
			int end  = xs.getLastRowNum();
			int start = xs.getFirstRowNum();

			for(int i=start;i<=end;i++) {

				System.out.print(xs.getRow(i).getCell(0).getStringCellValue() + "\t");
				System.out.print(xs.getRow(i).getCell(1).getStringCellValue() + "\t");
				System.out.print(xs.getRow(i).getCell(2).getStringCellValue() + "\t");
				System.out.print(xs.getRow(i).getCell(3).getStringCellValue() + "\t");
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
