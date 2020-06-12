package com.api.apiConfig;

import java.util.HashMap;
import java.util.Map;

public class HeadersConfig {
	
	public static Map<String,String> defaultHeaders(){
		Map<String,String> defaultHeaders=new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		return defaultHeaders;	
	}

	public static Map<String,String> headersWithToken(){
		Map<String,String> defaultHeaders=new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Access_Token", "ggsdjhgjdsdfjksdfkhkl");
		defaultHeaders.put("jwt_Token", "ggsdjhgjdsdfjksdfkhkljson");
		defaultHeaders.put("Tenet_user", "test");
		return defaultHeaders;
		
	}
	
}
