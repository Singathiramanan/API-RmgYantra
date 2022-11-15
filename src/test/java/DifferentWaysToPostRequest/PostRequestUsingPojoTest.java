package DifferentWaysToPostRequest;


import io.restassured.http.ContentType;
import pojoClasses.PojoClassForPostRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PostRequestUsingPojoTest {
	@Test
	public void postRequestUsingPojoTest()
	{
		PojoClassForPostRequest pojo=new PojoClassForPostRequest("saravana", "postrequestusingpojo1", "created", 5);
		baseURI="http://localhost";
		port=8084;
		given()
			.contentType(ContentType.JSON)
			.body(pojo)
		
			.when()
				.post("/addProject")
		
			.then()
				.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(201)
				.log().all();
	
	
	}

}
