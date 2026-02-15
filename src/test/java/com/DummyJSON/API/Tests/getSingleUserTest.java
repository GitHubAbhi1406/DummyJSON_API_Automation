package com.DummyJSON.API.Tests;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.JsonUtil.*;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getSingleUserTest extends BaseTest{
	
	Response res;
	JsonPath json;
	String un;
	String pw;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getReponseById(Routes.USER_BY_ID, 8);
	}
	
	@Test(priority = 1)
	public void logResponseBody() {
		System.out.println("-------------Response Body for Single User is as below--------------------");
		
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void verifyStatusCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void verifyHeaderContentType() {
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	}
	
	@Test(priority = 4)
	public void extractResponseData() {
		json = res.jsonPath();
		
		System.out.println("Below are the company details");
		Map<String, Object> company = new HashMap<>();
		
		company = json.getMap("company");
		
		System.out.println(company);
	}
	
	@Test(priority = 5)
	public void extractUserInfo() {
		json = res.jsonPath();
		
		un = json.getString("username");
		pw = json.getString("password");
		
		JsonFilePathUtil.saveLoginInfo(un,pw);
		
		
	}

}