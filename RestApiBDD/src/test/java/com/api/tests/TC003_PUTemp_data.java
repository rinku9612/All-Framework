package com.api.tests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.api.rest.utils.Javautils;

import io.restassured.RestAssured;

public class TC003_PUTemp_data {

	public static HashMap<String, String> map=new HashMap<String, String>();
	String empid="14";
	@BeforeClass
	public void putData() {
		map.put("employee_name", Javautils.getEmpName());
		map.put("employee_salary", Javautils.getEmpSal());
		map.put("employee_age", Javautils.getEmpAge());
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+empid;
	}
	
	@Test
	public void empUpdate() {
		given().contentType("application/json").body(map).
		when().put().then().
		statusCode(200).log().all();
	}
}
