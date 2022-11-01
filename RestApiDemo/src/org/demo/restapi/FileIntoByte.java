package org.demo.restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.reUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class FileIntoByte {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Validate if Addplace API  is working as expected
		//Addplace -> Update place with new address , Getplace -> Validate if new address is present in  response
		//given - all input details 
		//when - submit the API -resource and http method
		//then - validate the response
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Admin\\addPlace.json"))))
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(response);
		JsonPath jp =  new JsonPath(response);//for parsing json
		String placeId = jp.getString("place_id");
		
		System.out.println(placeId);
		
		//Update place
		String newAddress = "70 Gautham City walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get place
		String getplaceresponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath jp1 = reUsableMethods.rawToJson(getplaceresponse);
		String actualAddress = jp1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
	

	}

}
