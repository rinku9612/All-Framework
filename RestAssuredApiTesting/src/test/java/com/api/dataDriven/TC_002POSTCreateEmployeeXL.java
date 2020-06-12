package com.api.dataDriven;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.utils.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC_002POSTCreateEmployeeXL {

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
	String [][] getEmpData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\api\\documentation\\Empdata.xlsx";
		int rows=XLUtils.getRowCount(path, "Sheet1");
		int columns=XLUtils.getCellCount(path, "Sheet1", 1);
		String [][]empdata=new String[rows][columns];
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<columns;j++) {
				empdata[i-1][j] =XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return empdata;
	
	}
}
