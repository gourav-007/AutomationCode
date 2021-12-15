package com.seleneiumlearn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static HSSFRow row;
	private static XSSFCell cell;

	public void setExcelFile(String excelFilePath,String sheetName) throws IOException {
		//Create an object of File class to open xls file
		File file = new File("C:\\Users\\gourav.c.jain\\Desktop\\randomdatafordelete.xlsx");

		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		//creating workbook instance that refers to .xls file
		workbook=new XSSFWorkbook(inputStream);

		//creating a Sheet object
		sheet=workbook.getSheetAt(0);

	}

	public String getCellData(int rowNumber,int cellNumber){
		//getting the cell value from rowNumber and cell Number
		cell =sheet.getRow(rowNumber).getCell(cellNumber);

		//returning the cell value as string
		return cell.getStringCellValue();
	}

	public int getRowCountInSheet(){
		int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		return rowcount;
	}

	public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
		//creating a new cell in row and setting value to it      
		sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
	}
}
