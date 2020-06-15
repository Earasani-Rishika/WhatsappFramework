package com.Functionalty;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.Base.DriverBase;
import com.relevantcodes.extentreports.ExtentReports;

public class listeners implements ITestListener
{
	
	public static WebDriver driver;
	public static ExtentReports report;
	public listeners(WebDriver driver) throws IOException
	{
		this.driver=driver;
		//DriverBase.takeScreenShot(driver);
		//report = DriverBase.createReports();
		//this.report = report;
	}
	
	public listeners()
	{
		report = DriverBase.createReports();
		this.report = report;
	}
	
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String testName=result.getName();
		String testStep = result.getMethod().getMethodName();
		//DriverBase.testPassed(testName,report);
		DriverBase.testPassedOne(testName, "Present in"+testStep , report);
		
		
	}

	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
		try {
			DriverBase.takeScreenShot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String testName=result.getName();
		DriverBase.testFailed(testName,report);
	}

	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub
		
	}

}
