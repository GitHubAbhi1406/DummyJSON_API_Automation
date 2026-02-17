package com.DummyJSON.API.ApiUtils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiUtils{
	
	public static Response getResponse(String endpoint) {
		
		return given().
				log().all().
					when().
				get(endpoint);
	}
	
	public static Response getReponseById(String endpoint, int id) {
		
		return given().
				log().all().
					when().
						pathParam("id", id)
				.get(endpoint);
	}
	
	public static Response postLogin(String endpoint, String username, String password) {
		
		return given().contentType("application/json").
				body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }").
				when().
				post(endpoint);
	}
}