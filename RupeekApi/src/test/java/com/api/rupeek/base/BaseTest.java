package com.api.rupeek.base;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BaseTest {

	@Test
	public static String authorization() {
		
        baseURI="http://13.126.80.194:8080";
	    basePath="/authenticate";
		
		HashMap<String , String> map=new HashMap<String, String>();
		map.put("username", "rupeek");
		map.put("password","password");
		Response response = given().contentType("application/json").body(map).when().post();
		String token = response.jsonPath().getString("token");
	    
		return token;
	
	}
}
