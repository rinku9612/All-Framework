package com.api.rest.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Javautils {

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Rohit"+generatedString);
		
	}
	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("singh"+generatedString);
		
	}
	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Rinku"+generatedString);
		
	}
	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("rorin"+generatedString);
		
	}
	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Rohit"+generatedString+"@gmail.com");
	}
	public static String getEmpName() {
		String empName=RandomStringUtils.randomAlphabetic(2);
		return ("rohit"+empName);
	}
	public static String getEmpSal() {
		String empSal=RandomStringUtils.randomNumeric(5);
		return ("RS"+empSal);
	}
	public static String getEmpAge() {
		String empAge=RandomStringUtils.randomNumeric(2);
		return (empAge);
	}
}
