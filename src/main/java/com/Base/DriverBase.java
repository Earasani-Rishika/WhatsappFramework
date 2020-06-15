package com.Base;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverBase 
{
	//public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	static String curDir=System.getProperty("user.dir");
	static String reportsPath=curDir+"/ExtentReports/Report.html";
	static String screenshotsPath=curDir+"/ErrorScreenshots/screenshot.png";

	public static WebDriver Browser(WebDriver driver,String browser)
	{
	while(driver==null)
	 {
		if(browser.equalsIgnoreCase("chrome")) 
		{
	
			 driver = new ChromeDriver();
		}
	 }
	return driver;
	}

	
	public static void clickElement(WebDriver driver,By BtnLocator)
	{
		try
		{
		//DriverBase.driver.findElement(BtnLocator).click();	
		driver.findElement(BtnLocator).click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//switch to iframe
	public static void switchFrames(WebDriver driver, By iFrameLocator) 
	{
		try
		{
			driver.switchTo().frame(driver.findElement(iFrameLocator));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void waitTillLocatorIsVisibile(WebDriver driver, By Locator)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//send text to the textbox
	
	public static void sendText(WebDriver driver, By TxtLocator, String Text)
	{
		try
		{
		driver.findElement(TxtLocator).sendKeys(Text);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	// select value from dropdoen
	
	public static void selectValue(WebDriver driver,By selectLocator,String value)
	{
		Select month=new Select(driver.findElement(selectLocator));
		month.selectByValue(value);
	}
	
	//extent reports
	
	public static ExtentReports createReports()
	{
	report = new ExtentReports(reportsPath);
	return report;
	//test=report.startTest("Test Report");
	//test.log(LogStatus.PASS,"Test case is passed");
	}
	
	public static void testPassed(String testName, ExtentReports report)
	{
		test=report.startTest(testName+ "Test Report");
		test.log(LogStatus.PASS,testName+ "Test case is passed");
		//test.log(LogStatus.PASS, stepName, details);
		report.flush();
	}
	
	public static void testPassedOne(String testName,String testStep, ExtentReports report)
	{
		test=report.startTest(testName+ "Test Report");
		//test.log(LogStatus.PASS,testName+ "Test case is passed");
		test.log(LogStatus.PASS, testStep,"Test case is passed" );
		report.flush();
	}
	
	
	public static void testFailed(String testName, ExtentReports report)
	{
		test=report.startTest(testName+"Test Report");
		test.log(LogStatus.FAIL,testName+"Test case is failed");
		report.flush();
	}
	
public static void takeScreenShot(WebDriver driver) throws IOException
	{
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	Files.copy(file, new File("/Users/rishiv/eclipse-workspace/WhatsappFramework/ErrorScreenshots/screenshot.png"));
	
	}
	/*public
	 
	{
	try
	{
		List sheetData = new ArrayList();
		FileInputStream fis = new FileInputStream("/Users/rishiv/eclipse-workspace/SampleApplicationFramework/src/main/resources/TestData/LoginTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			String sheetname = wb.getSheetAt(i).getSheetName();
			if(sheetname.equalsIgnoreCase("Sheet1"))
			{
				XSSFSheet sheet=wb.getSheetAt(i);
				Iterator <Row> rows=sheet.iterator();
				if(rows.hasNext())
				{
					rows.next();
					Row secondRow = rows.next();
					Iterator <Cell> cells=secondRow.cellIterator();
					if(cells.hasNext())
					{
						XSSFCell cell=(XSSFCell) cells.next();
						List data = new ArrayList();
						data.add(cell);
						
						/*XSSFCell cell=(XSSFCell) cells.next();
						//String cellValue= cell.getStringCellValue();
						List list = new ArrayList();
						list.add(cell);
						
					}
					sheetData.add(data);
					ShowExcelData();
				}
			}
		}
	}
	catch(Exception e)
	{
		System.err.println(e.getMessage());
	}
		
	}

	private static void ShowExcelData() {
		// TODO Auto-generated method stub
		
	}*/
	
	/*public static List ReadExcelData() throws Exception
	{
	String filename = "/Users/rishiv/eclipse-workspace/SampleApplicationFramework/src/main/resources/TestData/LoginTestData.xlsx";
	 List sheetData = new ArrayList();
	 FileInputStream fis = null;
	        try {
	 fis = new FileInputStream(filename);
	 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(0);
	 Iterator rows = sheet.rowIterator();
	 			rows.next();
	            while (rows.hasNext()) {
	                XSSFRow row = (XSSFRow) rows.next();
	                Iterator cells = row.cellIterator();
	                List data = new ArrayList();
	                while (cells.hasNext()) {
	                    XSSFCell cell = (XSSFCell) cells.next();
	                    data.add(cell);
	                }
	                sheetData.add(data);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (fis != null) {
	                fis.close();
	            }
	        }
	        return sheetData;
	    }*/
	


	
	
	    /*private static void showExelData(List sheetData)
	     {
	     
	        //
	        // Iterates the data and print it out to the console.
	        //
	    	System.out.println(sheetData.size());
	        for (int i = 0; i < sheetData.size(); i++) 
	        {
	            List list = (List) sheetData.get(i);
	            for (int j = 0; j < list.size(); j++) 
	            {
	                XSSFCell cell = (XSSFCell) list.get(j);
	                System.out.print(cell.getRichStringCellValue().getString());
	                if (j < list.size() - 1)
	                {
	                    System.out.print(", ");
	                }
	            }
	       
	        }
	    }*/
	}
