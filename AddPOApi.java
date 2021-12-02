package PO;

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


public class AddPOApi

{

	
	@Test(invocationCount=1)
	void PostApiPrIssued()
	{
		
		String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=8299384121&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;	
	
		System.out.println(respone2);
		
//		 RestAssured.registerParser("text/plain", Parser.JSON);
//		JSONObject post =new JSONObject();
//		
//		post.put("projectId",1088);
//		post.put("projectName","rb Test");
//		post.put("projectAddressId",1204);
//		post.put("supplierId",2356);
//		post.put("supplierAddressId",null);
//		post.put("supplierName","dgfbdx");
//		post.put("rfqId",null);
//		
//		
//		JSONObject mat =new JSONObject();   
//		mat.put("materialUnitPrice",10);
//		mat.put("materialQty",1);
//		mat.put("brandNames",null);
//		mat.put("materialId",53995);
//		mat.put("fullfilmentDate",2021-11-30);
//		mat.put("documentList",null);
//		
//		
//	      post.putAll(mat);
	      
	      
		 //System.out.println("["+post.toJSONString()+"]");
		given()
		.body("[{\"projectId\":1458,\"projectName\":\"pr delete test 2 payment record check\",\"projectAddressId\":1590,\"supplierId\":2346,\"supplierAddressId\":null,\"supplierName\":\"gta90\",\"rfqId\":null,\"materialList\":[{\"materialUnitPrice\":1,\"materialQty\":1,\"brandNames\":null,\"materialId\":61726,\"fullfilmentDate\":\"2021-11-30\",\"documentList\":null}]}]")
		.header("Authorization",
				respone2)
		.header("Content-Type","application/json")
		.when()
		.post("https://dev-api.buildsupply.biz/im/po/addPO").
		
		then()
		//.statusCode(200)
		.log()
		.all();
	
	}

	

	
		
	


}
