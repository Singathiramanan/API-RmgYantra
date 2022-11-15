package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingJsonFileTest {
	@Test
	public void postRequestUsingJsonTest()
	{
		File f=new File(".\\src\\test\\resources\\JsonFile.json");
		baseURI="http://localhost";
		port=8084;
		
		given()
		    .body(f)
			.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject")
			
		.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
			
		
	}

}
