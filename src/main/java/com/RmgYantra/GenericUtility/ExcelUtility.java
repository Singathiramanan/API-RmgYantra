package com.RmgYantra.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String getStringExcelData(String sheetName, int rowNum, int celNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(celNum));
		return data;
	}

	public static int getNumericExcelData(String sheetName, int rowNum, int celNum)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);

		double data1 = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getNumericCellValue();
		int data = (int) data1;
		return data;

	}
	Workbook book;
	public String getDataFromExcel(String Excel_path, String SheetName, int rowNumber, int cellNumber)
		
		
		{		
			FileInputStream fis=null;
			try {
				fis = new FileInputStream(Excel_path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Sheet sheet = book.getSheet(SheetName);
			String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
			return data;
		}

	public String[][] getMultipleData(String Excel_path, String SheetName)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(Excel_path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
		DataFormatter df = new DataFormatter();
		String[][] arr = new String[sheet.getLastRowNum() + 1][sheet.getRow(sheet.getLastRowNum()).getLastCellNum()];

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(sheet.getLastRowNum()).getLastCellNum(); j++) {
				arr[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}

		}
		return arr;
	}
}
