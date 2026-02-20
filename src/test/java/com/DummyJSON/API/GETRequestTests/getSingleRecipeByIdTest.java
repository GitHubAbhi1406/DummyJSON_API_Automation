package com.DummyJSON.API.GETRequestTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DummyJSON.API.GETRequestApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class getSingleRecipeByIdTest extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getReponseById(Routes.RECEPI_BY_ID, 2);
	}
	
	@Test(priority = 1)
	public void printResponse() {
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void checkStatusCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	public void checkData(){
		String name = res.jsonPath().getString("name");
		String cuisine = res.jsonPath().getString("cuisine");
		
		Assert.assertEquals(name, "Vegetarian Stir-Fry");
		Assert.assertEquals(cuisine, "Asian");
		
		System.out.println("Name id the dish : "+name+"\n"+"Name of the cuisine : "+cuisine);
	}
}