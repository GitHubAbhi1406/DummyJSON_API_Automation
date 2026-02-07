package com.DummyJSON.API.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getProductbyidTest extends BaseTest{
	
	Response res;
	JsonPath json;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getReponseById(Routes.PRODUCTS_BY_ID, 2);
	}
	
	@Test(priority = 1)
	public void printResponse() {
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void checkStatusCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void checkResponseBody() {
		json = res.jsonPath();
		Assert.assertEquals(json.getInt("id"), 2);
	}
	
	public void storeResponseDimension() {
		json = res.jsonPath();
		Map<String, Float> dimensions = json.getMap("dimensions");
		
		System.out.println(dimensions);
	}
}