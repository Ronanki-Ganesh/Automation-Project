package com.NopCommerce.Tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelReader {
	static FileInputStream file;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static DataFormatter formatter;

	public static Object[][] readExcel(String filePath, String sheetName) throws Exception, NullPointerException {
		try {

			// we can create a file input stream in Java.
			file = new FileInputStream(".\\DataFiles\\testdata.xlsx");
			// Creating A work book
			wb = new XSSFWorkbook(file);
			// Creating the sheet
			sheet = wb.getSheet(sheetName);
			// Getting rows and column.
			int rowCount = sheet.getLastRowNum();
			int column = sheet.getRow(0).getLastCellNum();

			// It is creating an array of references to arrays of references to Objects
			Object[][] data = new Object[rowCount][column];
			for (int i = 1; i <= rowCount; i++) {
				row = sheet.getRow(i);
				for (int j = 1; j < column; j++) {
					cell = row.getCell(j);
					//methods for formatting the value stored in a Cell
					formatter = new DataFormatter();
					//Returns the formatted value of a cell as a String 
					String val = formatter.formatCellValue(cell);
					//returns or sets the value attribute of the selected elements
					data[i - 1][j] = val;
				}
			}
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}