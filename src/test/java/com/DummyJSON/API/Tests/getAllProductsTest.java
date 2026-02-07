package com.DummyJSON.API.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class getAllProductsTest extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getProducts() {
		res = ApiUtils.getResponse(Routes.PRODUCTS);
	}
	
	@Test(priority = 1)
	public void getResponseBody() {
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void checkStatusCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}