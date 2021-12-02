package Demo_MM_API;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.lang.MetaClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.parsing.Parser;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.internal.RestAssuredResponseImpl;


public class GetApiTesting

{

	@Test(priority=0)
	void LoginToken() {
		 RestAssured.registerParser("text/plain", Parser.JSON);
		JSONObject post = new JSONObject();

		
		
	String response=	given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response;
		System.out.println(respone2);
		
//		String response1=given().body("loginIdType=PHONE&countryCode=%2B91&username=8299384121&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
//				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
//				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
//				.post("https://dev-api.buildsupply.io/sso/oauth/token").asPrettyString();
//		System.out.println(response1);
		
		
		given().header("Authorization",
				respone2)
					.get("https://dev-api.buildsupply.biz/im/materials/details/1414/61135").then().log().all();
		
	}
}
		