package PO;
import org.apache.poi.xssf.util.NumericRanges;
import static io.restassured.RestAssured.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





import com.Test.Utility.Xls_Reader;

import com.Test.Utility.excelUtil;

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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.restassured.parsing.Parser;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.internal.RestAssuredResponseImpl;

public class deletePoApi {
	
	@DataProvider
	public Iterator <Object[]> GetMmData() throws InvalidFormatException{
		ArrayList <Object[]> data=excelUtil.getDataFromExcel();
		return data.iterator();
	}
		
	 @Test(priority = 1, dataProvider="GetMmData")
	  void DeletePO(String poId ) {

		RestAssured.registerParser("text/plain", Parser.JSON);
		JSONObject post = new JSONObject();

		String response = given().body(
				"loginIdType=PHONE&countryCode=%2B91&username=9746466556&password=password&grant_type=password&client_id=fooClientIdPassword&userType=BUYER")
				.header("Authorization", "Basic Zm9vQ2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=")
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").when()
				.post("https://dev-api.buildsupply.biz/sso/oauth/token").jsonPath().getString("serviceToken");

		String respone2 = "Bearer " + response;
		System.out.println(respone2);
		System.out.println(poId);
		

		
			String poID = "https://dev-api.buildsupply.biz/im/po/delete/" + poId;
			Response console = given().header("Accept", "*/*").header("Authorization", respone2)

					.delete(poID).then().statusCode(200).log().all().extract().response();
			System.out.println(console);
		}

	}

