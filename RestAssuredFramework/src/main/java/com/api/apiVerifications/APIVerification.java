package com.api.apiVerifications;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.testng.Assert;

import com.api.javautils.ExtentReportsListener;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class APIVerification extends ExtentReportsListener {

	
	public static void validateStatusCode(Response response, int statuscode) {
		try {
			Assert.assertEquals(response.getStatusCode(), statuscode);
			tests.log(LogStatus.PASS, "Successfully validated StatusCode,statuscode is::" + statuscode);
		} catch (AssertionError e) {
			tests.log(LogStatus.FAIL, e.fillInStackTrace());
			tests.log(LogStatus.FAIL,
					"Expected statuscode is::" + statuscode + "but found::" + response.getStatusCode());
			
		} catch (Exception e) {
			tests.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void validateTime(Response response,int time) {
		long actTime = response.getTimeIn(TimeUnit.SECONDS);
		try {
			
			Assert.assertTrue(actTime < time);
			tests.log(LogStatus.PASS, "Response time is less than 3 sec::" + actTime);
		} catch (AssertionError e) {
			tests.log(LogStatus.FAIL,"Response time is greater than 3 sec::"+ actTime);
			tests.log(LogStatus.FAIL, e.fillInStackTrace());
		} catch (Exception e) {
			tests.log(LogStatus.FAIL, e.fillInStackTrace());
		}

	}
	/*
	 * public static void validateJsonBody(Response response,String key) {
	 * 
	 * JSONObject json=new JSONObject(response.getBody().asString()); try {
	 * if(json.has(key) && json.get(key)!=null) { tests.log(LogStatus.PASS,
	 * "Succesfully validated "+key+"::value is"+json.get(key)); }else {
	 * tests.log(LogStatus.FAIL, "Key is not available"); } }catch(Exception e) {
	 * tests.log(LogStatus.FAIL, e.fillInStackTrace()); } }
	 */
	
	public static void validateStatusLine(Response response,String statusline) {
		response.getStatusLine();
		try {
			Assert.assertEquals(response.getStatusLine(), statusline);
			tests.log(LogStatus.PASS, "Successfully validated statusLine");
		} catch (AssertionError e) {
			tests.log(LogStatus.FAIL,"Status line validation failed,expected::"+statusline+" but found::"+response.getStatusLine());
			tests.log(LogStatus.FAIL, e.fillInStackTrace());
		} catch (Exception e) {
			tests.log(LogStatus.FAIL, e.fillInStackTrace());
		}

	}
}
