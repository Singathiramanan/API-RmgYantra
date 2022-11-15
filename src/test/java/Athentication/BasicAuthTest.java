package Athentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthTest {
	@Test
	public void athentication() {
		baseURI="http://localhost";
		port=8085;
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("login")
		.then()
			.assertThat().statusCode(202)
			.log().all();
		
	}
}
