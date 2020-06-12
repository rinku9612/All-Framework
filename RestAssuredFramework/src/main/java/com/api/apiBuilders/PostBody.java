package com.api.apiBuilders;

import java.util.HashMap;
import java.util.Map;

import com.api.javautils.ExtentReportsListener;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class PostBody extends ExtentReportsListener{

	public static Map<String,String> postBody(String name,String job){
		Map<String,String> body=new HashMap<String, String>();
		body.put("Name",name );
		body.put("Job",job );
		return body;		
	}
	
	public static String getJsonBody(Response response) {
		tests.log(LogStatus.INFO, ":::--Response Body is--:::"+response.getBody().asString());
		return response.getBody().asString();
	}
}
