package APITestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetRequestWithContentType {
	@Test
	public void postAJsonBody(){
		
		
		baseURI="http://localhost";
		port=8085;
		
		given()
				
				.contentType(ContentType.JSON)
		.when()
				.get("/projects")
		.then()
				.assertThat()
					.statusCode(200)
					.contentType(ContentType.JSON);
					
		
	}
}
