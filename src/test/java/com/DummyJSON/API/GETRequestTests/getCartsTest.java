package com.DummyJSON.API.GETRequestTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DummyJSON.API.GETRequestApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class getCartsTest extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getResponse(Routes.CARTS);
	}
	
	@Test(priority = 1)
	public void printResponse() {
		System.out.println("Response body is as below");
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void checkResponseCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
}