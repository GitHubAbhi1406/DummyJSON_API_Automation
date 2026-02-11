package com.DummyJSON.API.Tests;

import java.io.File;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.PostApiUtils.PostRequestApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class createPostTest extends BaseTest{
	
	
	Response res;
	
	@BeforeClass
	public void getResponse() {
		res = PostRequestApiUtils.postResponse(Routes.POSTS, new File("src/test/resources/PostJsonFiles/postPost.json"));
	}
	
	@Test
	public void printResponse() {
		res.then().log().all();
	}
}