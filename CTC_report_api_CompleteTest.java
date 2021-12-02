package CTC;

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


public class CTC_report_api_CompleteTest

{

	
	@Test(invocationCount=1)
	void CTC() throws InterruptedException
	{
		
		String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;	
	
		System.out.println(respone2);
		
		 RestAssured.registerParser("text/plain", Parser.JSON);
		

		 Response  responseLOG =given()
		.body("{\"projectIdList\":[\"1477\",\"1452\"],\"amountFlag\":\"amount\"}")
		.header("Authorization",
				respone2)
		.header("Content-Type","application/json")
		.when()
		.post("https://dev-api.buildsupply.biz/im/report/ctcReport");
		 
		 Assert.assertEquals(responseLOG.asString(), "{\"estimatedAmount\":6900,\"awardedAmount\":9910,\"deliveredAmount\":9760,\"paidAmount\":4197.5,\"projectedCost\":11613,\"projectDataList\":[{\"projectId\":1477,\"projectName\":\"ctc api test 1\",\"estimatedAmount\":4200,\"awardedAmount\":7758,\"deliveredAmount\":7608,\"paidAmount\":3650,\"projectedCost\":8908,\"materialCategoryDataList\":[{\"materialCategoryName\":\"Civil and Structure\",\"materialUnit\":\"MT\",\"estimatedAmount\":4200,\"awardedAmount\":7550,\"deliveredAmount\":7500,\"projectedCost\":8700,\"materialCTCDataList\":[{\"materialCode\":\"ML_MGCS0001_008\",\"materialName\":\"White Cement\",\"material_id\":61814,\"materialGroup\":\"Civil and Structure\",\"materialUnit\":\"kg\",\"projectId\":1477,\"projectName\":\"ctc api test 1\",\"estimatedAmount\":1400,\"estimatedTaxAmount\":140,\"estimatedRate\":1,\"estimatedTaxRate\":10,\"awardedAmount\":1900,\"awardedTaxAmount\":-6,\"deliveredAmount\":1900,\"deliveredTaxAmount\":-6,\"pendingAmount\":1300,\"pendingTaxAmount\":130,\"projectedCTC\":2300,\"projectedTaxCTC\":34},{\"materialCode\":\"ML_MGCS0001_006\",\"materialName\":\"Cement Bulker OPC 43 Grade\",\"material_id\":61815,\"materialGroup\":\"Civil and Structure\",\"materialUnit\":\"MT\",\"projectId\":1477,\"projectName\":\"ctc api test 1\",\"estimatedAmount\":1400,\"estimatedTaxAmount\":140,\"estimatedRate\":1,\"estimatedTaxRate\":10,\"awardedAmount\":1950,\"awardedTaxAmount\":24,\"deliveredAmount\":1900,\"deliveredTaxAmount\":14,\"pendingAmount\":1300,\"pendingTaxAmount\":130,\"projectedCTC\":2300,\"projectedTaxCTC\":59},{\"materialCode\":\"ML_MGCS0001_007\",\"materialName\":\"Cement Bulker OPC 53 Grade\",\"material_id\":61816,\"materialGroup\":\"Civil and Structure\",\"materialUnit\":\"MT\",\"projectId\":1477,\"projectName\":\"ctc api test 1\",\"estimatedAmount\":1400,\"estimatedTaxAmount\":140,\"estimatedRate\":1,\"estimatedTaxRate\":10,\"awardedAmount\":3700,\"awardedTaxAmount\":184,\"deliveredAmount\":3700,\"deliveredTaxAmount\":184,\"pendingAmount\":1300,\"pendingTaxAmount\":130,\"projectedCTC\":4100,\"projectedTaxCTC\":224}]}],\"otherCostInfo\":{\"materialCategoryName\":\"Other Cost\",\"materialUnit\":\"\",\"estimatedAmount\":0,\"awardedAmount\":208,\"deliveredAmount\":108,\"projectedCost\":208,\"materialCTCDataList\":null}},{\"projectId\":1452,\"projectName\":\"ctc api test 2 shortclose po direct grn\",\"estimatedAmount\":2700,\"awardedAmount\":2152,\"deliveredAmount\":2152,\"paidAmount\":547.5,\"projectedCost\":2705,\"materialCategoryDataList\":[{\"materialCategoryName\":\"Construction Equipments\",\"materialUnit\":\"barrel\",\"estimatedAmount\":400,\"awardedAmount\":324,\"deliveredAmount\":324,\"projectedCost\":400,\"materialCTCDataList\":[{\"materialCode\":\"CMT_1345_000038\",\"materialName\":\"s2\",\"material_id\":61708,\"materialGroup\":\"Construction Equipments\",\"materialUnit\":\"barrel\",\"projectId\":1452,\"projectName\":\"ctc api test 2 shortclose po direct grn\",\"estimatedAmount\":400,\"estimatedTaxAmount\":40,\"estimatedRate\":1,\"estimatedTaxRate\":10,\"awardedAmount\":324,\"awardedTaxAmount\":30.4,\"deliveredAmount\":324,\"deliveredTaxAmount\":30.4,\"pendingAmount\":376,\"pendingTaxAmount\":37.6,\"projectedCTC\":400,\"projectedTaxCTC\":38}]},{\"materialCategoryName\":\"Civil and Structure\",\"materialUnit\":\"MT\",\"estimatedAmount\":2300,\"awardedAmount\":1823,\"deliveredAmount\":1823,\"projectedCost\":2300,\"materialCTCDataList\":[{\"materialCode\":\"CMT_1345_000037\",\"materialName\":\"s1\",\"material_id\":61707,\"materialGroup\":\"Civil and Structure\",\"materialUnit\":\"bag\",\"projectId\":1452,\"projectName\":\"ctc api test 2 shortclose po direct grn\",\"estimatedAmount\":800,\"estimatedTaxAmount\":80,\"estimatedRate\":1,\"estimatedTaxRate\":10,\"awardedAmount\":323,\"awardedTaxAmount\":30.3,\"deliveredAmount\":323,\"deliveredTaxAmount\":30.3,\"pendingAmount\":777,\"pendingTaxAmount\":77.7,\"projectedCTC\":800,\"projectedTaxCTC\":78},{\"materialCode\":\"ML_MGCS0001_007\",\"materialName\":\"Cement Bulker OPC 53 Grade\",\"material_id\":61817,\"materialGroup\":\"Civil and Structure\",\"materialUnit\":\"MT\",\"projectId\":1452,\"projectName\":\"ctc api test 2 shortclose po direct grn\",\"estimatedAmount\":500,\"estimatedTaxAmount\":0,\"estimatedRate\":1,\"estimatedTaxRate\":0,\"awardedAmount\":500,\"awardedTaxAmount\":50,\"deliveredAmount\":500,\"deliveredTaxAmount\":50,\"pendingAmount\":300,\"pendingTaxAmount\":0,\"projectedCTC\":500,\"projectedTaxCTC\":50},{\"materialCode\":\"ML_MGCS0001_008\",\"materialName\":\"White Cement\",\"material_id\":61818,\"materialGroup\":\"Civil and Structure\",\"materialUnit\":\"kg\",\"projectId\":1452,\"projectName\":\"ctc api test 2 shortclose po direct grn\",\"estimatedAmount\":500,\"estimatedTaxAmount\":0,\"estimatedRate\":1,\"estimatedTaxRate\":0,\"awardedAmount\":500,\"awardedTaxAmount\":50,\"deliveredAmount\":500,\"deliveredTaxAmount\":50,\"pendingAmount\":300,\"pendingTaxAmount\":0,\"projectedCTC\":500,\"projectedTaxCTC\":50},{\"materialCode\":\"ML_MGCS0001_006\",\"materialName\":\"Cement Bulker OPC 43 Grade\",\"material_id\":61819,\"materialGroup\":\"Civil and Structure\",\"materialUnit\":\"MT\",\"projectId\":1452,\"projectName\":\"ctc api test 2 shortclose po direct grn\",\"estimatedAmount\":500,\"estimatedTaxAmount\":0,\"estimatedRate\":1,\"estimatedTaxRate\":0,\"awardedAmount\":500,\"awardedTaxAmount\":50,\"deliveredAmount\":500,\"deliveredTaxAmount\":50,\"pendingAmount\":300,\"pendingTaxAmount\":0,\"projectedCTC\":500,\"projectedTaxCTC\":50}]}],\"otherCostInfo\":{\"materialCategoryName\":\"Other Cost\",\"materialUnit\":\"\",\"estimatedAmount\":0,\"awardedAmount\":5,\"deliveredAmount\":5,\"projectedCost\":5,\"materialCTCDataList\":null}}],\"allOtherCostInfo\":{\"projectId\":0,\"projectName\":\"Total Other Cost\",\"estimatedAmount\":0,\"awardedAmount\":213,\"deliveredAmount\":113,\"paidAmount\":0,\"projectedCost\":213,\"materialCategoryDataList\":null,\"otherCostInfo\":{\"materialCategoryName\":\"\",\"materialUnit\":\"\",\"estimatedAmount\":0,\"awardedAmount\":0,\"deliveredAmount\":0,\"projectedCost\":0,\"materialCTCDataList\":null}}}");		 
		
		 
		 		
		
	}

	
	



	
		
	


}
