package com.w2a.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.base.TestBase;

import com.w2a.utilities.TestUtil;
public class CustomListeners extends TestBase implements ITestListener{

	
	public void onTestStart(ITestResult result) {

	
		/*
		 * ExtentTest test =
		 * extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.
		 * getMethod().getMethodName()); testReport.set(test);
		 */
        

	}

	public void onTestSuccess(ITestResult result) {

		

	}

	public void onTestFailure(ITestResult result) {

		try {

			TestUtil.captureScreenshot();
			Reporter.log("Click to see Screenshot");
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
		} catch (IOException e) {

		}
		

	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ISuite arg0) {
		
		
	}

	public void onStart(ISuite arg0) {
		
		
	}

	public void onFinish(ITestContext context) {


		
	}


}
