package com.api.tests;

import org.testng.annotations.Test;

import com.api.apiConfig.ApiPath;
import com.api.apiVerifications.APIVerification;
import com.api.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqresApi_GET extends BaseTest {

	@Test
	public void getAllUsers() {
		Response response = RestAssured.given().when().get(ApiPath.APIPath.GET_ALL_USERS);
		tests.log(LogStatus.INFO, "Response Body::"+response.asString());
		  APIVerification.validateStatusCode(response, 200);
		  APIVerification.validateTime(response,3);
		  APIVerification.validateStatusLine(response, "HTTP/1.1 200 OK");

		  String key=response.then().extract().path("data.email[2]");
		  tests.log(LogStatus.PASS, key);
		 
	}
	@Test
	public void getSingleUser() {
		Response response = RestAssured.given().when().get(ApiPath.APIPath.GET_SINGLE_USER);
		tests.log(LogStatus.INFO, "Response Body::"+response.asString());
		  APIVerification.validateStatusCode(response, 200);
		  APIVerification.validateTime(response,3);
		  APIVerification.validateStatusLine(response, "HTTP/1.1 200 OK");
		  
	}
	@Test
	public void getSingleUserNotFound() {
		Response response = RestAssured.given().when().get(ApiPath.APIPath.GET_SINGLE_USER_NOT_FOUND);
		tests.log(LogStatus.INFO, "Response Body::"+response.asString());
		  APIVerification.validateStatusCode(response, 200);
		  APIVerification.validateTime(response,3);
		  APIVerification.validateStatusLine(response, "HTTP/1.1 200 OK");
		  
	}
	@Test
	public void getListResource() {
		Response response = RestAssured.given().when().get(ApiPath.APIPath.GET_LIST_RESOURCE);
		tests.log(LogStatus.INFO, "Response Body::"+response.asString());
		  APIVerification.validateStatusCode(response, 200);
		  APIVerification.validateTime(response,3);
		  APIVerification.validateStatusLine(response, "HTTP/1.1 200 OK");
		 
	}
	@Test
	public void getSingleResource() {
		Response response = RestAssured.given().when().get(ApiPath.APIPath.GET_SINGLE_RESOURCE);
		tests.log(LogStatus.INFO, "Response Body::"+response.asString());
		  APIVerification.validateStatusCode(response, 200);
		  APIVerification.validateTime(response,3);
		  APIVerification.validateStatusLine(response, "HTTP/1.1 200 OK");
		
	}
	@Test
	public void getDelayedResponse() {
		Response response = RestAssured.given().when().get(ApiPath.APIPath.GET_DELAYED_RESPONSE);
		tests.log(LogStatus.INFO, "Response Body::"+response.asString());
		  APIVerification.validateStatusCode(response, 200);
		  APIVerification.validateTime(response,4);
		  APIVerification.validateStatusLine(response, "HTTP/1.1 200 OK");
		 
	}
}
