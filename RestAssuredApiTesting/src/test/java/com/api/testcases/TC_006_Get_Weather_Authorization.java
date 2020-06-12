package com.api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_Get_Weather_Authorization {
	
	@Test
	public void get_weather() {
		RestAssured.baseURI="https://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		RestAssured.authentication=auth;
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine=response.getStatusLine();
		System.out.println("StatusLine is:"+statusLine);
	}

}
