package com.DummyJSON.API.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class getSingleCartTest extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getReponseById(Routes.CARTS_BY_ID, 5);
		
	}
	
	@Test
	public void printResponse() {
		System.out.println("Response");
		res.then().log().all();
	}
}