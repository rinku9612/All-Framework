package com.api.tests;

import org.testng.annotations.Test;
import static  io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class TC001_Validate_Weather_GET {

	@Test
	public void getWeather() {
		given().
		when().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK").
		assertThat().body("City", equalTo("Hyderabad")).
		header("Content-Type", "application/json");
	}
}
