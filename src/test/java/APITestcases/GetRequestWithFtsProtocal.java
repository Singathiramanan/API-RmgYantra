package APITestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class GetRequestWithFtsProtocal {
	@Test
	public void ProtocalWithSecure(){
		baseURI="fts://localhost";
		port=8085;
		given()
		.when()
			.get("/projects")
		.then()
			.log().all()
			.assertThat()
				.statusCode(200);
		
	}
}
