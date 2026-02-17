package com.DummyJSON.API.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class getSingleCommentTest extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		
		res = ApiUtils.getReponseById(Routes.Get_SingleComment, 6);
	}
	
	@Test(priority = 1)
	public void printResponse() {
		
		System.out.println("----------Response is as below-------------");
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void checkResponse() {
		
		String username = res.jsonPath().getString("user.username");
		int user_id = res.jsonPath().getInt("user.id");
		
		Assert.assertEquals(username, "danielt");
		Assert.assertEquals(user_id, 110);
	}
}