package Athentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

public class DigestTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		baseURI="http://localhost";
		port=8085;
		given()
			.auth().digest("rmgyantra", "rmgy@9999")
		.when()
			.get("login")
		.then()
					.assertThat().statusCode(202)
					.log().all();
	}

}
