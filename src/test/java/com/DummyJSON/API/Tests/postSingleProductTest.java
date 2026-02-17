package com.DummyJSON.API.Tests;

import java.io.File;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.DummyJSON.API.PostApiUtils.PostRequestApiUtils;
import com.DummyJSON.API.baseFile.BaseTest;
import com.DummyJSON.API.endpoints.Routes;
import io.restassured.response.Response;

public class postSingleProductTest extends BaseTest{
	Response res;
	
	@BeforeClass
	public void postProduct() {
		
		res = PostRequestApiUtils.postResponse(Routes.ADD_PRODUCTS, new File("src/test/resources/PostJsonFiles/postProduct.json"));
	}
	
	@Test
	public void printResponse() {
		res.then().log().all();
	}
}