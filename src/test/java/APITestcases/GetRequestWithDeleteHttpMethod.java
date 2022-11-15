package APITestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class GetRequestWithDeleteHttpMethod {
	@Test
	public void fetchAllTheprojects(){
		baseURI="http://localhost";
		port=8085;
		given()
		.when()
			.delete("/projects")
		.then()
			.log().all()
			.assertThat()
				.statusCode(200);
		
	}
}
