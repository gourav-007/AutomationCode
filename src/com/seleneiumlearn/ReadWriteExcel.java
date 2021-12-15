package com.seleneiumlearn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	public static void main(String[] args) throws Exception {
		//i have an excel sheet/workbook/cells/file... i want to read it.
		//i have an excel where i want to write.
		File f = new File("C:\\Users\\gourav.c.jain\\Desktop\\data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		XSSFSheet sh = wbk.getSheetAt(0);
		// System.out.println("total rows are:" + sh.getPhysicalNumberOfRows());
		// System.out.println("total cols are:" + sh.getRow(0).getPhysicalNumberOfCells());
		// System.out.println("total cols in second row are:" + sh.getRow(1).getPhysicalNumberOfCells());
		// System.out.println("the value is:" + sh.getRow(0).getCell(0).getStringCellValue());
		for(int i=0; i<sh.getPhysicalNumberOfRows(); i++)
		{
			for(int j=0; j<sh.getRow(i).getPhysicalNumberOfCells(); j++)
			{
				System.out.println("the value is:" + sh.getRow(i).getCell(j).getStringCellValue());
			}
		}
		sh.createRow(2).createCell(0).setCellValue("accenture");
		sh.getRow(2).createCell(1).setCellValue("noida");
		FileOutputStream fos = new FileOutputStream(f);
		wbk.write(fos);
		wbk.close();
		fos.close();
		fis.close();
	}

}

