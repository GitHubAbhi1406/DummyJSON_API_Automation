package com.DummyJSON.API.GETRequestTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DummyJSON.API.GETRequestApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class getAllUsersTest extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		
		res = ApiUtils.getResponse(Routes.USERS);
	}
	
	@Test(priority = 1)
	public void printResponse() {
		System.out.println("------------------Response for all users is as below----------------------------");
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void checkResponseCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void validateResponseHeader() {
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	}
}