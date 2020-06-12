package com.api.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST_Customer {

	@Test
	public void succesfullRegister() {
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("FirstName","Rohirtkumars");
		requestParams.put("LastName","Rinrkuk");
		requestParams.put("UserName","rohritsXYZa");
		requestParams.put("Password","rirnkuxyxb");
		requestParams.put("Email","rinrkusrk@gmail.com");

		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());

		Response response=httpRequest.request(Method.POST,"/register");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);

		int statusCode=response.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 201);
		String statusLine=response.getStatusLine();
		System.out.println("StatusLine is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		String succescode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(succescode, "OPERATION_SUCCESS");
	}

}
