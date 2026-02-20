package com.DummyJSON.API.GETRequestTests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.DummyJSON.API.GETRequestApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getAllCommentsTest extends BaseTest{
	
	Response res;
	JsonPath json;
	
	@BeforeClass
	public void getResponse() {
		
		res = ApiUtils.getResponse(Routes.GET_COMMENTS);
	}
	
	@Test(priority = 1)
	public void printResponse() {
		
		System.out.println("--------------------Response Body is as below-----------------");
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void checkStatusCode() {
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void checkResponseHeaders() {
		
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	}
	
	@Test(priority = 4)
	public void extractResponse() {
		
		json = res.jsonPath();
		
		List<String> body = new ArrayList<>();
		
		body = json.getList("comments.body");
		
		for(int i=0;i<body.size();i++) {
			System.out.println(body.get(i));
		}
	}
	
}