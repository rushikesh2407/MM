package PR_api;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.parsing.Parser;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.internal.RestAssuredResponseImpl;


public class indent_list_projectID

{

	
	@Test(priority=4)
	void PostApiPrIssued()
	{
		
		String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;	
	
		
		
		 RestAssured.registerParser("text/plain", Parser.JSON);
		JSONObject post =new JSONObject();
		
		post.put("projectId",1385);
		ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
	      list.add("2194");//Adding object in arraylist    
		post.put("indentRaisedByList",list);
		
//		post.put("issuedDate","2021-10-13");
//		post.put("raisePrComments","");
//		post.put("requiredQuantity",100);
//		post.put("issueToPrComments","k1");
		
		// System.out.println(post.toJSONString());
		given()
		.body(post.toJSONString())
		.header("Authorization",
				respone2)
		.header("Content-Type","application/json")
		.when()
		.post("https://dev-api.buildsupply.biz/im/indent/list/1385").
		
		then()
		.statusCode(200)
		.log()
		.all();
	
	}

	

	
		
	


}
