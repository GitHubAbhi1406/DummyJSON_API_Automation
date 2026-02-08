package com.DummyJSON.API.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

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
	
	@Test(priority = 3)
	public void extractResponseData() {
		JsonPath jsonPath = res.jsonPath();
		
		List<Map<String, Object>> products_list = jsonPath.getList("products.findAll {it.category == 'beauty'}");
		List<Map<String, Object>> products_stock_info = jsonPath.getList("products.findAll {it.availabilityStatus == 'In Stock'}");
		
		System.out.println("List of producst size : "+products_list.size());
		
		for(Map<String, Object> product : products_list) {
			System.out.println(product.get("title"));
		}
		
		System.out.println("\n");
		
		for(Map<String, Object> product : products_stock_info) {
			System.out.println(product.get("title"));
		}
	}
}