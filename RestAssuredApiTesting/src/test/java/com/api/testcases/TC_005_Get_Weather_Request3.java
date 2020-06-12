package com.api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_Get_Weather_Request3 {
	
	@Test
	public void get_weather() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Delhi");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		
		JsonPath jsonpath=response.jsonPath();
		Assert.assertEquals(jsonpath.get("City"), "Delhi");
		Assert.assertEquals(jsonpath.get("Temperature"), "29 Degree celsius");
		Assert.assertEquals(jsonpath.get("Humidity"), "39 Percent");
		Assert.assertEquals(jsonpath.get("WeatherDescription"), "haze");
		Assert.assertEquals(jsonpath.get("WindSpeed"), "2.1 Km per hour");
		Assert.assertEquals(jsonpath.get("WindDirectionDegree"), "290 Degree");
	}//https://restapi.demoqa.com/authentication/CheckForAuthentication

}
