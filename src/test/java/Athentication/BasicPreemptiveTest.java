package Athentication;

import static io.restassured.RestAssured.*;

public class BasicPreemptiveTest {
	public static void main(String[] args) {
		baseURI="http://localhost";
		port=8085;
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("login")
		.then()
					.assertThat().statusCode(202)
					.log().all();
	}
}
