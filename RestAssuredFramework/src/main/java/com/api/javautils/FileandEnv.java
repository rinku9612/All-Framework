package com.api.javautils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileandEnv {

	public static Map<String, String> envAndFile = new HashMap<String, String>();
	public static Properties propmain = new Properties();
	public static FileInputStream fis;

	public static Map<String,String> envandfile(){
	String environment=System.getProperty("env");
	
		
		try {
			if(environment.equalsIgnoreCase("dev")) {
			fis=new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties");
			propmain.load(fis);
			envAndFile.put("testserverUrl", propmain.getProperty("testserverUrl"));
			envAndFile.put("port", propmain.getProperty("port"));
			envAndFile.put("username", propmain.getProperty("username"));
			envAndFile.put("password", propmain.getProperty("password"));
		}
			else if(environment.equalsIgnoreCase("staging")) {
					fis=new FileInputStream(System.getProperty("user.dir")+"/inputs/staging.properties");
					propmain.load(fis);
					envAndFile.put("testserverUrl", propmain.getProperty("testserverUrl"));
					envAndFile.put("port", propmain.getProperty("port"));
					envAndFile.put("username", propmain.getProperty("username"));
					envAndFile.put("password", propmain.getProperty("password"));
				}

			else if(environment.equalsIgnoreCase("qa")) {
					fis=new FileInputStream(System.getProperty("user.dir")+"/inputs/qa.properties");
					propmain.load(fis);
					envAndFile.put("testserverUrl", propmain.getProperty("testserverUrl"));
					envAndFile.put("port", propmain.getProperty("port"));
					envAndFile.put("username", propmain.getProperty("username"));
					envAndFile.put("password", propmain.getProperty("password"));
				}
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	return envAndFile;

}

	public static Map<String,String> getConfig(){
		if(envAndFile==null)
		{
			envAndFile=envandfile();
		}
		return envAndFile;
		
	}
}
