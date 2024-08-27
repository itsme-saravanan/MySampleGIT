package a2_ValidatingResponse;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class A1_ValidatingGetResponse {

	public static void main(String[] args) {
	RestAssured.baseURI = "https://reqres.in";
		String response = given().log().all().header("Content-Type","application/json")
	
		.when().get("/api/users?page=2")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Checking the Response: "+ response);
		JsonPath js = new  JsonPath(response);
		String ID = js.getString("data[4].last_name");
		System.out.println("Checking the ID: " +ID);
		
	}
}
