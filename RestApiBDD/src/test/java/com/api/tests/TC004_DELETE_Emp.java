package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class TC004_DELETE_Emp {

	@Test
	public void deleteEmp()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/14";
		
		given().when().delete().then().statusCode(200).log().all()
		.extract().response();
	}
	}
