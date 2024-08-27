package a2_ValidatingResponse;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class A3_PostCreatingMethodforBody {
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		String postresponse = given().log().all().header("Content-Type","application/json")
		.body(A4_BodyForPost.output())
				.when().post("api/users")
				.then().log().all().assertThat().statusCode(201).extract().asString();
		
		System.out.println("Checking the Response: "+postresponse);
		JsonPath js = new  JsonPath(postresponse);
		String ID = js.getString("id");
		System.out.println("Checking the ID: " +ID);
	

	}

}
