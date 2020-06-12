package com.api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_Get_Weather_RequestDelhi {
	
	@Test
	public void get_weather() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Delhi");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		
		Assert.assertEquals(responseBody.contains("Delhi"),true);
	}

}
