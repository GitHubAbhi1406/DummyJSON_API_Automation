package com.DummyJSON.API.PostApiUtils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;

public class PostRequestApiUtils{
	
	public static Response postResponse(String endpoint, File requestbody) {
		
		return given().headers("Content-Type", "application/json")
				.body(requestbody)
				.when()
				.post(endpoint);
	}
	
	public static Response postUserInfo(String endpoint, File requestBody) {
		
		return given().
				header("Content-Type", "application/json")
				.body(requestBody)
				.when()
				.post(endpoint);
	}
}