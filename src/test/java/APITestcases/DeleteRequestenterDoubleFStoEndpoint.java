package APITestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class DeleteRequestenterDoubleFStoEndpoint {
	@Test
	public void mistakeInEndpoint(){
		baseURI="http://localhost";
		port=8085;
		given()
			.delete("projects//TY_PROJ_833")
			.then()
				.assertThat()
					.statusCode(204)
				.log().all();
	}
}
