package a1_Restassured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class PutRequest {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://reqres.in";
		given().log().all().header("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}")
		.when().put("/api/users/2")
		.then().log().all().assertThat().statusCode(200);
	}
}
