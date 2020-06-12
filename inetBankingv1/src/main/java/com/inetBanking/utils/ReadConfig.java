package com.inetBanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop; 
	public ReadConfig(){
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);

		}
		catch(Exception e) 
		{
			System.out.println("Exception is:"+e.getMessage());
		}}
	public String getUrl() {
		String url=prop.getProperty("baseUrl");
		return url;
	}
	public String getUsername() {
		String user=prop.getProperty("username");
		return user;
	}
	public String getPass() {
		String pass=prop.getProperty("password");
		return pass;
	}
	public String getChroPath() {
		String cropath=prop.getProperty("chromepath");
		return cropath;
	}
	public String getFirePath() {
		String firepath=prop.getProperty("firepath");
		return firepath;
	}
	public String getEdgePath() {
		String edgepath=prop.getProperty("edgepath");
		return edgepath;
	}
	
	public String getChroKey() {
		String crokey=prop.getProperty("chromeKey");
		return crokey;
	}
	public String getFireKey() {
		String firekey=prop.getProperty("firefoxKey");
		return firekey;
	}
	public String getEdgeKey() {
		String edgekey=prop.getProperty("edgeKey");
		return edgekey;
	}
}
