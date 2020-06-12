package com.inetBanking.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Reporting implements ITestListener 
{
	public static ExtentReports reports;
	public static ExtentTest test;
	
	
	public void onStart(ITestContext context) {
		reports=new ExtentReports("test-output/Report/test/ExtentReport.html");
	
	}
	public void onTestStart(ITestResult result) {
		test=reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "Test is Pass");
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "Test is Fail");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	

	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();
	}

}