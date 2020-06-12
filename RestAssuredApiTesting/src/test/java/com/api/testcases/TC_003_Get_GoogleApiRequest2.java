package com.api.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_Get_GoogleApiRequest2 {
	
	@Test
	public void get_weather() {
	
		RestAssured.baseURI="https://maps.googleapis.com";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine=response.getStatusLine();
		System.out.println("StatusLine is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		String contentType=response.header("Content-Type");
		System.out.println("Content-Type is:"+contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentEncoding=response.getHeader("Content-Encoding");
		System.out.println("Content-Encoding is :"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		String server=response.getHeader("Server");
		System.out.println("Server is:"+server);
		Assert.assertEquals(server, "scaffolding on HTTPServer2");
		Headers allHeaders = response.headers();
		for(Header headers:allHeaders) {
			System.out.println(headers.getName()+" : "+headers.getValue());
			
		}
	}

}
