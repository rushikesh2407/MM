package PR_api;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class pr_list_materialID

{
	@Test
	void issueToPr_updatestockApi() {
		RestAssured.registerParser("text/plain", Parser.JSON);
		JSONObject post = new JSONObject();

		String response = given().body(
				"loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER")
				.header("Authorization", "Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");

		String respone2 = "Bearer " + response;
		System.out.println(respone2);

		given().header("Authorization", respone2)
				.get("https://dev-api.buildsupply.biz/im/pr/list/58811").then().statusCode(200).log()
				.all();

	}
}