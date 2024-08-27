package a3_ParmaterPassing;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class A1_AddingPayloadThroughParameter {
@Test
public static void main(String[] args) {
	RestAssured.baseURI = "https://reqres.in";
	String postresponse = given().log().all().header("Content-Type", "application/json")
			.body(A3_DataProvider.parameterPassing("Saravnan", "Tester")).when().post("api/users").then().log().all()
			.assertThat().statusCode(201).extract().asString();

	System.out.println("Checking the Response: " + postresponse);
	JsonPath js = new JsonPath(postresponse);
	String ID = js.getString("id");
	System.out.println("Checking the ID: " + ID);


}
	
}
