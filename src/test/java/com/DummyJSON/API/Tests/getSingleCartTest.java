package com.DummyJSON.API.Tests;

import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getSingleCartTest extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getReponseById(Routes.CARTS_BY_ID, 5);
		
	}
	
	@Test(priority = 1)
	public void printResponse() {
		System.out.println("Response");
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void extractTtile() {
		JsonPath json = res.jsonPath();
		
		List<String> products_list = json.getList("products.title", String.class);
		
		System.out.println(products_list);
	}
}