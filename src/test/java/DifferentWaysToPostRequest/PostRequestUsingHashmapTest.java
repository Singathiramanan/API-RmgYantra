package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingHashmapTest {
	@SuppressWarnings("unchecked")
	@Test
	public void postRequestUsingHashmapTest()
	{
		@SuppressWarnings("rawtypes")
		HashMap hm=new HashMap();
		hm.put("createdBy", "saravanan");
		hm.put("projectName", "PCDOC");
		hm.put("status", "Created");
		hm.put("teamSize", 4);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
			.body(hm)
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
