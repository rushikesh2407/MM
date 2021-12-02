package Liability;

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


public class Liliability_report_test_api

{

	
	@Test(invocationCount=1)
	void liability() throws InterruptedException
	{
		
		String response0=	given().body("loginIdType=PHONE&countryCode=%2B91&username=8299384121&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER").header("Authorization",
				"Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");
		
		String respone2="Bearer " +response0;	
	
		System.out.println(respone2);
		
		 RestAssured.registerParser("text/plain", Parser.JSON);
		

		 Response  responseLOG =given()
		.body("{\"projectIdList\":[\"1468\"],\"supplierIdList\":[]}")
		.header("Authorization",
				respone2)
		.header("Content-Type","application/json")
		.when()
		.post("https://dev-api.buildsupply.biz/im/supplier/getLiabilityReport");
		 
		 Assert.assertEquals(responseLOG.asString(), "{\"totalTaxAmount\":0,\"totalPoAmount\":210,\"otherCost\":0,\"gstAmount\":0,\"grnAmount\":200,\"poAmount\":210,\"paymentRecived\":200,\"supplierReportDataList\":[{\"supplierId\":2385,\"supplierName\":\"dvsvx\",\"totalTaxAmount\":0,\"totalPoAmount\":10,\"otherCost\":0,\"gstAmount\":0,\"grnAmount\":0,\"poAmount\":10,\"paymentRecived\":0,\"projectReportDataList\":[{\"projectId\":1468,\"projectName\":\"Testbug\",\"totalTaxAmount\":0,\"totalPoAmount\":10,\"otherCost\":0,\"gstAmount\":0,\"grnAmount\":0,\"poAmount\":10,\"paymentRecived\":0,\"entityDataList\":[{\"entityId\":4520,\"entityLabel\":\"1468-6\",\"entityType\":\"purchaseOrder\",\"totalTaxAmount\":0,\"totalPoAmount\":10,\"otherCost\":0,\"gstAmount\":0,\"grnAmount\":0,\"poAmount\":10,\"paymentRecived\":0,\"currencyCode\":\"\"}],\"currencyCode\":\"\"}],\"currencyCode\":\"\"},{\"supplierId\":2033,\"supplierName\":\"sdaass11123\",\"totalTaxAmount\":0,\"totalPoAmount\":200,\"otherCost\":0,\"gstAmount\":0,\"grnAmount\":200,\"poAmount\":200,\"paymentRecived\":200,\"projectReportDataList\":[{\"projectId\":1468,\"projectName\":\"Testbug\",\"totalTaxAmount\":0,\"totalPoAmount\":200,\"otherCost\":0,\"gstAmount\":0,\"grnAmount\":200,\"poAmount\":200,\"paymentRecived\":200,\"entityDataList\":[{\"entityId\":3961,\"entityLabel\":\"Direct GRN - 3961\",\"entityType\":\"grn\",\"totalTaxAmount\":0,\"totalPoAmount\":200,\"otherCost\":0,\"gstAmount\":0,\"grnAmount\":200,\"poAmount\":200,\"paymentRecived\":200,\"currencyCode\":\"\"}],\"currencyCode\":\"\"}],\"currencyCode\":\"\"}],\"currencyCode\":\"\"}");		 
		
		 
		 		
		
	}

	
	



	
		
	


}
