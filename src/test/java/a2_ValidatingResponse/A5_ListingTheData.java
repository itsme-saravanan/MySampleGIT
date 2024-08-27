package a2_ValidatingResponse;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class A5_ListingTheData {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://reqres.in";
		String response = given().header("Content-Type", "application/json")

				.when().get("/api/users?page=2").then().assertThat().statusCode(200).extract().response().asString();

		System.out.println("Checking the Response: " + response);
		JsonPath js = new JsonPath(response);
		int count = js.getInt("data.size()");
		System.out.println("Checking the size of Data: " + count);
		String data = "Fields";
		for (int i = 0; i < count; i++) {
			if (js.getString("data[" + i + "].last_name").equals(data)) {
				String text = (js.getString("data[" + i + "].first_name"));
				System.out.println("First Name is: " + text);
			}
			break;
		}
	}
}
