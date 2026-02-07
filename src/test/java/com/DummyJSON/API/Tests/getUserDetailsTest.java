package com.DummyJSON.API.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class getUserDetailsTest extends BaseTest{
	
	Response res;
	String email;
	String password;
	String username;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getReponseById(Routes.USER_BY_ID, 2);
	}
	
	@Test(priority = 1)
	public void printResponse() {
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void validateResponseCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void storeCredentials() {
		email = res.jsonPath().getString("email");
		password = res.jsonPath().getString("password");
		username = res.jsonPath().getString("username");
		
		System.out.println(email +" "+password+" "+username);
	}
	
	@Test(priority = 4)
	public void checkLoginResponse() {
		Response login = ApiUtils.postLogin(Routes.LOGIN_INFO, username, password);
		
		login.then().log().all();
		
		System.out.println(login.jsonPath().getString("token"));
	}
}