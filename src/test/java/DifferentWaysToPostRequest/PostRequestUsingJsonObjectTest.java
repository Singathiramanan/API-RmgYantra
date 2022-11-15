package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestUsingJsonObjectTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void postRequestUsingJsonObjectTest()
	{
		
		//Create a body using json simple
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "yuvi");
		jobj.put("projectName", "postusingjsonobj1");
		jobj.put("status", "Created");
		jobj.put("teamSize", 4);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
			.body(jobj)
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
