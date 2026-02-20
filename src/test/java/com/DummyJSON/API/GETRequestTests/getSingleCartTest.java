package com.DummyJSON.API.GETRequestTests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import com.DummyJSON.API.GETRequestApiUtils.ApiUtils;
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
	public void validateResponseCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void extractTtile() {
		JsonPath json = res.jsonPath();
		
		List<String> products_list = json.getList("products.title", String.class);
		
		System.out.println(products_list);
		System.out.println("Test Pass");
	}
	
	@Test(priority = 4)
	public void validateResponseSchema() {
		res.then().assertThat().body(matchesJsonSchemaInClasspath("CartsSchema/cartsSchema.json"));
	}
}