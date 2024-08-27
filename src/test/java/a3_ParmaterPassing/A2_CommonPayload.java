package a3_ParmaterPassing;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class A2_CommonPayload {

	@Test(dataProvider = "testdata")
	public static void postRequest(String Name, String Job) throws IOException {
		RestAssured.baseURI = "https://reqres.in";
		String postresponse = given().log().all().header("Content-Type", "application/json")
//				.body(Data_Provider.parameterPassing(Name, Job))
				.body(new String(Files.readAllBytes(Paths.get("E:\\eclipse\\eclipse-workspace\\APITesting\\src\\test\\java\\a3_ParmaterPassing\\UpdatedJSON.json"))))
				.when().post("api/users").then().log().all()
				.assertThat().statusCode(201).extract().asString();
		System.out.println("Checking the Response: " + postresponse);
		JsonPath js = new JsonPath(postresponse);
		String ID = js.getString("id");
		System.out.println("Checking the ID: " + ID);
	}
	
	@DataProvider(name="testdata")
	public static  Object[][] provideData(){
		Object[][] data = new Object[3][2];
		data[0][0] = "Saravanan";
		data[0][1] = "lead";
		data[1][0] = "Karthik";
		data[1][1] = "Tester";
		data[2][0] = "Sandhya";
		data[2][1] = "QA";
// 		return new Object[][] {{"Saravanan","Lead"}{"Karthikeyan","Tester"}{"Sandhya","Quality"}}
		
		return data;
	}
}