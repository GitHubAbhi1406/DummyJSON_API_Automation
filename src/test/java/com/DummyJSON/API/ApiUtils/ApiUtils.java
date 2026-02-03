package com.DummyJSON.API.ApiUtils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiUtils{
	
	public static Response getResponse(String endpoint) {
		
		return given().when().get(endpoint);
	}
}