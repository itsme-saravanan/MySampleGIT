package a1_Restassured;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class HttpBasicMethods {
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		
		given().log().all().header("Content-Type","application/json")
		
		.when().get("api/users?page=2")
		
		.then().log().all().assertThat().statusCode(200);
		
	}
}
