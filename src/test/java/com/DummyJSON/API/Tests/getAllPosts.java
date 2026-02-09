package com.DummyJSON.API.Tests;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.ApiUtils.ApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getAllPosts extends BaseTest{
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		res = ApiUtils.getResponse(Routes.POSTS);
		
		System.out.println("----------------------Response is as below-------------------");
		
		res.then().log().all();
	}
	
	@Test(priority = 1)
	public void checkResponseCode() {
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void extractResponse() {
		
		JsonPath json = res.jsonPath();
		
		List<Map<String, Object>> title_items = json.getList("posts.findAll {it.tags.contains('fiction')}.title");
		
		System.out.println("List size: "+title_items.size());
		
		for(int i =0;i<title_items.size();i++) {
			System.out.println(title_items.get(i));
		}
		
		System.out.println();
		
		List<Map<String, Object>> title_even_id = json.getList("posts.findAll {it.id % 2 == 0 }.title");
		
		for(int j=0;j<title_even_id.size();j++) {
			System.out.println(title_even_id.get(j));
		}
	}
}