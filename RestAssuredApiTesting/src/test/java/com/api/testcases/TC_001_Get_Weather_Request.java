package com.api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Get_Weather_Request {
	
	@Test
	public void get_weather() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine=response.getStatusLine();
		System.out.println("StatusLine is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
