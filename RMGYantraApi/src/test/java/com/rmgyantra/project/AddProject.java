package com.rmgyantra.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import rmgyantra.genericlib.BaseLib;
import rmgyantra.genericlib.DbUtilities;
import rmgyantra.genericlib.IEndPoints;

import static io.restassured.RestAssured.*;

public class AddProject extends BaseLib{
	
	@Test
	public void addSingleProjectTest() throws Throwable {
		String actDbProjectName=null;
		String actProjectStatus=null;
		
		FileInputStream fis=new FileInputStream(new File("./resources/Addproject.json"));
		Response response=given().
				contentType(ContentType.JSON).
				body(IOUtils.toByteArray(fis)).
				when().post(IEndPoints.add_Single_Project);
		
		response.then().assertThat().statusCode(201);
		long actrespTime=response.timeIn(TimeUnit.MILLISECONDS);
		
		String actProjectName=response.jsonPath().getString("projectName").toString();
		ResultSet result=DbUtilities.executeQuery("select * from project where project_name='"+actProjectName+"'");
		while(result.next()) {
			actDbProjectName=result.getString(2);
			actProjectStatus=result.getString(5);
		}
		
		Assert.assertEquals(actProjectStatus, "Created");
		Assert.assertEquals(actProjectName, actDbProjectName);
	}

}
