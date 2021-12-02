package TradeFliter;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class tradeFliter

{
	@Test
	void tradeFilterAPI() {

		String response0 = given().body(
				"loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER")
				.header("Authorization", "Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");

		String respone2 = "Bearer " + response0;

		RestAssured.registerParser("text/plain", Parser.JSON);

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("limit", "25");
		parameters.put("page", "1");
		parameters.put("tradeName", "Electrical,Finishing Works");

		given().header("Authorization", respone2).params(parameters).get(
				"https://dev-api.buildsupply.biz/im/materials/v1/1385?limit=25&pageNumber=1&tradeName=Electrical,Finishing Works")
				.then().statusCode(200).log().all();

	}
}