package com.api.dataDriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC_001POSTCreateEmployee {

	@Test(dataProvider ="empdata")
	void create_employee(String ename,String esal,String eage) {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		JSONObject params=new JSONObject();
		params.put("name",ename);
		params.put("salary",esal);
		params.put("age",eage);
		httprequest.header("Content-Type","application/json");
		httprequest.body(params.toJSONString());
		Response response = httprequest.request(Method.POST,"/create");
		String responseBody=response.getBody().asString();
		
		System.out.println("Response body:"+responseBody);
		Assert.assertEquals(responseBody.contains(ename),true);
		Assert.assertEquals(responseBody.contains(esal),true);
		Assert.assertEquals(responseBody.contains(eage),true);
	}
	
	@DataProvider(name="empdata")
	String [][] getEmpData()
	{
	String [][] empdata= {{"rohit","50000","31"},{"rinku","40000","32"},{"rohit","60000","33"}};
	return empdata;
	}
}
