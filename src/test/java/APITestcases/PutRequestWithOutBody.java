package APITestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutRequestWithOutBody {
	@Test
	public void withOutBody(){
		
		baseURI="http://localhost";
		port=8085;
		given()
			
			.contentType(ContentType.JSON)
		.when()
			.put("/projects/TY_PROJ_003")
		.then()
			.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.log().all();
			
	}
	

}
