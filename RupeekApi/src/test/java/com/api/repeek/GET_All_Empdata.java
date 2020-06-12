package com.api.repeek;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.api.rupeek.base.BaseTest;

public class GET_All_Empdata extends BaseTest
{
  // @Test
   public void getAlldata()
   {
given().auth().oauth2(authorization()).get("http://13.126.80.194:8080/api/v1/users")
			   .then().log().all();
   }
   
   @Test
   public void getSingleUser() {
	   given().auth().oauth2(authorization()).get("http://13.126.80.194:8080/api/v1/users/9995879555")
	   .then().
	   log().all();
   }
}
