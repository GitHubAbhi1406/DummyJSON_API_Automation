package com.DummyJSON.API.Tests;

import java.io.File;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.PostApiUtils.PostRequestApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class checkLoginCreds extends BaseTest {
	
	Response res;
	String token;
	
	@BeforeClass
	public void getResponse() {
		
		File loginFile = new File("src/test/resources/PostJsonFiles/loginInfo.json");
		res = PostRequestApiUtils.postResponse(Routes.LOGIN_INFO, loginFile);
	}
	
	@Test(priority = 1)
	public void logResponse() {
		res.then().log().all();
	}
	
	@Test(priority = 2)
	public void storeToken() {
		token = res.jsonPath().getString("accesstoken");
	}
}