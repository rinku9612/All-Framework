package com.api.repeek;

import static io.restassured.RestAssured.given;

import org.junit.Test;


import com.api.rupeek.base.BaseTest;
import com.github.fge.jsonschema.main.JsonSchema;
import static org.hamcrest.Matchers.*;

import org.hamcrest.text.MatchesPattern;

public class SchemaValidator extends BaseTest {

	
	/*//@Test
	   public void getAlldata()
	   {
	given().auth().oauth2(authorization()).get("http://13.126.80.194:8080/api/v1/users")
				   .then().assertThat().body(matchesJsonSchemaInClasspath)
	   }
}
*/
}