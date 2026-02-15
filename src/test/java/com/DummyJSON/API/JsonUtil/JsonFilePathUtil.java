package com.DummyJSON.API.JsonUtil;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFilePathUtil{
	
	public static void saveLoginInfo(String username, String password) {
		
		try {
			Map<String, String> loginData = new HashMap<>();
			loginData.put("username",username);
			loginData.put("password",password);
			
			ObjectMapper mapper = new ObjectMapper();
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/PostJsonFiles/loginInfo.json"), loginData);
			
			System.out.println("Login Data created successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	}