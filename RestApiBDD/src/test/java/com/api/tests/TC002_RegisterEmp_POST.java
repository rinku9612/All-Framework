package com.api.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.api.rest.utils.Javautils;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
public class TC002_RegisterEmp_POST {
	
	static Map<String,String> map=new HashMap<String,String>();
	@BeforeTest
	public void postData() {
		map.put("FirstName",Javautils.getFirstName());
		map.put("LastName",Javautils.getLastName());
		map.put("UserName",Javautils.getUserName());
		map.put("Password",Javautils.getPassword());
		map.put("Email",Javautils.getEmail());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	@Test
	public void post_userRequest() {
		given().
		contentType("application/json").
		body(map).
		when().
		post().
		then().statusCode(200).and()
		.statusLine("HTTP/1.1 200 OK").and()
		.body("fault",equalTo("FAULT_USER_ALREADY_EXISTS"));
		
	}

}
