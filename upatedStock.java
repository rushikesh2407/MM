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


public class upatedStock

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
		
//		String response1=given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
//				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
//				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
//				.post("https://dev-api.buildsupply.io/sso/oauth/token").asPrettyString();
//		System.out.println(response1);
		
		
		given().header("Authorization",
				respone2)
					.get("https://dev-api.buildsupply.biz/im/materials/updateStock/58813/1385").then().statusCode(200).log().all();
		
	}
		
	
	@Test(priority=1)
    void issueTOPr1()
    {
    	String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;    	
    	
    	
    	
    	
		Response response= given().header("Authorization",
				respone2)
				.get("https://dev-api.buildsupply.biz/im/materials/updateStock/58717/1368");
		System.out.println(response.asString());
		
		System.out.println(response.getHeaders());
		int statusCode=response.getStatusCode();
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(statusCode, 200);
		
    }

	
@Test(priority=2)
	void issueTOPR2()
	{
		String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;		
		
		
		 RestAssured.registerParser("text/plain", Parser.JSON);
		given().
		header("Authorization",
				respone2).
		get("https://dev-api.buildsupply.biz/im/materials/updateStock/58813/1385").
		then()
		.statusCode(200)
		.log()
		.all()
		.body("data.materialName",equalTo("Ordinary Portland Cement Grade 53"))
		.body("data.returnQty", equalTo(59))
		.body("data.materialCode", equalTo("ML_MGCS0001_003"));		
		
	
			
		
	
		
		
	}
	
	

	

	@Test(priority=3)
	void tradeFilterAPI()
	{
		
		String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;	
		
			
		
		 RestAssured.registerParser("text/plain", Parser.JSON);
		
		 Map<String, String> parameters = new HashMap<String, String>();
		 parameters.put("limit", "25");
		 parameters.put("page", "1");
		 parameters.put("tradeName", "Electrical,Finishing Works");
		 
		given().
		header("Authorization",
				respone2)
		.params(parameters)
		.get("https://dev-api.buildsupply.biz/im/materials/v1/1385?limit=25&pageNumber=1&tradeName=Electrical,Finishing Works").
		then()
		.statusCode(200)
		.log()
		.all();
	
	}
	
	
	@Test(priority=4)
	void PostApiPrIssued()
	{
		
		String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;	
	
		
		
//		 RestAssured.registerParser("text/plain", Parser.JSON);
		JSONObject post =new JSONObject();
		
	//	post.put("indentId",875);
		post.put("issuedQty",1);
	//	post.put("issuedDate","2021-09-29");
	//	post.put("raisePrComments","");
	//	post.put("requiredQuantity",100);
		post.put("issueToPrComments","k1");
		
		 System.out.println("["+post.toJSONString()+"]");
		given()
		.body("["+post.toJSONString()+"]")
		.header("Authorization",
				respone2)
		.header("Content-Type","application/json")
		.when()
		.post("https://dev-api.buildsupply.biz/im/indent/issueQty/58812").
		
		then()
		//.statusCode(200)
		.log()
		.all();
	
	}

	

	
		
	


}
