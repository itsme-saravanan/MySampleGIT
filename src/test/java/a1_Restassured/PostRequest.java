package a1_Restassured;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class PostRequest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://reqres.in";
		given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}")
				.when().post("api/users")
				.then().log().all().assertThat().statusCode(201);

	}
}
