package com.api.tests;
import static  io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class TC005_Basic_validations {

	//@Test
	public void testStatusCode() {
		given().when().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200);
	}
	//@Test
	public void logResponse() {
		given().when().get("http://jsonplaceholder.typicode.com/posts").then().log().all();
	}
	
	//@Test
	public void verifysingleresponse() {
		given().when().get("https://reqres.in/api/users?page=27id=8")
		.then().body("ad.url", equalTo("http://statuscode.org/"));
	
	}
	@Test
		public void verifyMultipleresponse() {
			given().when().get("https://reqres.in/api/users?page=2")
			.then().body("data.first_name",hasItems("Michael","Lindsay","Byron"));
		
	}	
}
