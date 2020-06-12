package com.api.tests;



import org.testng.annotations.Test;

import com.api.apiBuilders.PostBody;
import com.api.apiConfig.ApiPath;
import com.api.apiConfig.HeadersConfig;
import com.api.apiVerifications.APIVerification;
import com.api.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqresApi_POST extends BaseTest{

	@Test
	public static void postUser() {
		Response response=RestAssured.given().when().headers(HeadersConfig.defaultHeaders()).body(PostBody.postBody("rohit", "QA")).
		when().post(ApiPath.APIPath.POST_CREATE_USER);
		
		PostBody.getJsonBody(response);
		APIVerification.validateStatusCode(response, 201);
		APIVerification.validateStatusLine(response, "HTTP/1.1 201 Created");
		APIVerification.validateTime(response, 3);
		
	}
	
	@Test
	public static void registerSucces() {
		Response response=RestAssured.given().when().headers(HeadersConfig.defaultHeaders()).auth().basic("rinku@gmail.com", "pistol").
        post(ApiPath.APIPath.POST_REGISTER_USER);
		APIVerification.validateStatusCode(response, 200);
		APIVerification.validateTime(response, 3);
	}
}
