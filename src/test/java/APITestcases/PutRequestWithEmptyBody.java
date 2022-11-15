package APITestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutRequestWithEmptyBody {
	@Test
	public void completeUpdateProject(){
		Random random=new Random();
		@SuppressWarnings("unused")
		int ran = random.nextInt(1000);
		JSONObject jobj=new JSONObject();
		
		baseURI="http://localhost";
		port=8085;
		given()
			.body(jobj)
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
