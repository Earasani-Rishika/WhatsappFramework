package com.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilFunctions 
{

	// Main Directory of the project
	public static final String currentDir = System.getProperty("user.dir");

	// Location of Test data excel file
	public static String testDataExcelPath = "src/main/resources/TestData";

	// Excel WorkBook
	private static XSSFWorkbook excelWBook;

	// Excel Sheet
	private static XSSFSheet excelWSheet;

	// Excel cell
	private static XSSFCell cell;

	// Excel row
	private static XSSFRow row;

	// Row Number
	public static int rowNumber;

	// Column Number
	public static int columnNumber;

	// Setter and Getters of row and columns
	public static void setRowNumber(int pRowNumber) {
	rowNumber = pRowNumber;
	}

	public static int getRowNumber() {
	return rowNumber;
	}

	public static void setColumnNumber(int pColumnNumber) {
	columnNumber = pColumnNumber;
	}

	public static int getColumnNumber() {
	return columnNumber;
	}
	
	public static FileInputStream ExcelFile;
	// This method has two parameters: "Test data excel file name" and "Excel sheet
	// name"
	// It creates FileInputStream and set excel file and excel sheet to excelWBook
	// and excelWSheet variables.
	public static void setExcelFileSheet(String testDataExcelFileName, String sheetName) throws Exception {
	try {
	// Open the Excel file
	 ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
	excelWBook = new XSSFWorkbook(ExcelFile);
	excelWSheet = excelWBook.getSheet(sheetName);
	} catch (Exception e) {
	try {
	throw (e);
	} catch (IOException e1) {
	e1.printStackTrace();
	}
	}
	}

	// This method reads the test data from the Excel cell.
	// We are passing row number and column number as parameters.
	public static String getCellData(String testDataExcelFileName,String sheetName, int RowNum, int ColNum) throws Exception {
	try {
	FileInputStream ExcelFile = new FileInputStream(testDataExcelPath +testDataExcelFileName);
	excelWBook = new XSSFWorkbook(ExcelFile);
	excelWSheet = excelWBook.getSheet(sheetName);
	cell = excelWSheet.getRow(RowNum).getCell(ColNum);
	DataFormatter formatter = new DataFormatter();
	String cellData = formatter.formatCellValue(cell);

	return cellData;
	} catch (Exception e) {
	throw (e);
	}
	}

	// This method takes row number as a parameter and returns the data of given row
	// number.
	public static XSSFRow getRowData(int RowNum) throws Exception {
	try {
	row = excelWSheet.getRow(RowNum);
	return row;
	} catch (Exception e) {
	throw (e);
	}
	}

	public static int fetchLastRowNum(String testDataExcelFileName,String sheetName) throws Exception {
	try {
	FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
	excelWBook = new XSSFWorkbook(ExcelFile);
	excelWSheet = excelWBook.getSheet(sheetName);
	int rowsNum = excelWSheet.getPhysicalNumberOfRows();
	return rowsNum;
	} catch (Exception e) {
	throw (e);
	}

	}

	/*
	// This method gets excel file, row and column number and set a value to the
	// that cell.
	public static void setCellData(String sheetName, int RowNum, int ColNum, String result)
	throws Exception {
	try {
	FileInputStream ExcelFile = new FileInputStream(testDataExcelPath);
	excelWBook = new XSSFWorkbook(ExcelFile);
	excelWSheet = excelWBook.getSheet(sheetName);
	row = excelWSheet.getRow(RowNum);
	CellStyle style_Green = excelWBook.createCellStyle();
	style_Green.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	style_Green.setFillPattern(FillPatternType.BIG_SPOTS);
	CellStyle style_Red = excelWBook.createCellStyle();
	style_Red.setFillBackgroundColor(IndexedColors.RED.getIndex());
	style_Red.setFillPattern(FillPatternType.BIG_SPOTS);
	cell = row.getCell(ColNum);
	if (cell == null) {
	cell = row.createCell(ColNum);
	if (result == "PASS") {
	cell.setCellValue(result);
	cell.setCellStyle(style_Green);

	} else {
	cell.setCellValue(result);
	cell.setCellStyle(style_Red);
	}
	} else {
	if (result == "PASS") {
	cell.setCellValue(result);
	cell.setCellStyle(style_Green);

	} else {
	cell.setCellValue(result);
	cell.setCellStyle(style_Red);
	}
	}
	// Constant variables Test Data path and Test Data file name
	FileOutputStream fileOut = new FileOutputStream(testDataExcelPath);
	excelWBook.write(fileOut);
	fileOut.flush();
	fileOut.close();
	} catch (Exception e) {
	try {
	throw (e);
	} catch (IOException e1) {
	e1.printStackTrace();
	}
	}
	}*/
	
}
