package Demo_MM_API;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostApiTest {
	@Test(priority = 1)
	void PostApiPrIssued() {

		String response0 = given().body(
				"loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER")
				.header("Authorization", "Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");

		String respone2 = "Bearer " + response0;

		
//		 RestAssured.registerParser("text/plain", Parser.JSON);
		JSONObject post =new JSONObject();
		
		post.put("projectId",1411);
		post.put("materialId",60617);
		post.put("unusableQuantity",1);
		post.put("remarks","");
		post.put("unusedType","available_stock");
		
		
		 System.out.println(post.toJSONString());
		given()
		.body(post.toJSONString())
		.header("Authorization",
				respone2)
		.header("Content-Type","application/json")
		.header("Content-Length",5)
		.header("Host","https://dev-mm.buildsupply.biz/")
		.when()
		.post("https://dev-api.buildsupply.biz/im/materials/add/unusableMaterials").		
		then()
		.log()
		.all().statusCode(200);
	}

}
