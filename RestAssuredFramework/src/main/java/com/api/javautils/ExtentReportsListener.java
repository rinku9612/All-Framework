package com.api.javautils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsListener implements ITestListener{

	public static ExtentReports reports;
	public static ExtentTest tests;
	
	private static String resultpath=getResultPath();
	public static void deleteDirctory(File directory) {
		if(directory.exists()) {
			File[] files = directory.listFiles();
			if(null!=files) {
				for(int i=0;i<files.length;i++) {
					System.out.println(files[i].getName());
					if(files[i].isDirectory()) {
						deleteDirctory(files[i]);
					}else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {
		resultpath="tests";
		if(! new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}
	
	String ReportLocation="test-output/Report/"+resultpath+"/";

	public void onTestStart(ITestResult result) {
		tests=reports.startTest(result.getMethod().getMethodName());
		tests.log(LogStatus.INFO, result.getMethod().getMethodName());
		System.out.println(result.getTestClass().getTestName());
		System.out.println(result.getMethod().getMethodName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
	tests.log(LogStatus.PASS, "Test is passed");
	}


	public void onTestFailure(ITestResult result) {
		tests.log(LogStatus.FAIL, "Test is failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		tests.log(LogStatus.SKIP, "Test is skipped");

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		}


	public void onStart(ITestContext context) {
		System.out.println(ReportLocation+"ReportLocation");
		reports=new ExtentReports(ReportLocation+"ExtentReport.html");
		tests=reports.startTest("");
	}


	public void onFinish(ITestContext context) {
		reports.endTest(tests);
		reports.flush();
	}
}
