package com.api.base;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.api.javautils.ExtentReportsListener;

import io.restassured.RestAssured;
@Listeners(ExtentReportsListener.class)
public class BaseTest extends ExtentReportsListener {

	@BeforeTest
	public void setUp() {
		
		RestAssured.baseURI="https://reqres.in/";
		
	}
}
