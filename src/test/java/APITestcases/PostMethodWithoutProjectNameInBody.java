package APITestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostMethodWithoutProjectNameInBody {
	@SuppressWarnings("unchecked")
	@Test
	public void passWithoutProjectName(){
		Random random=new Random();
		@SuppressWarnings("unused")
		int ran = random.nextInt(1000);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Ramanan");
		//jobj.put("projectName", "Singathicart"+ran);
		jobj.put("status", "created");
		jobj.put("teamSize", 6);
		
		baseURI="http://localhost";
		port=8085;
		
		given()
				.body(jobj)
				.contentType(ContentType.JSON)
		.when()
				.post("/addProject")
		.then()
				.assertThat()
					.statusCode(201)
					.contentType(ContentType.JSON)
					.log().all();
		
	}
}
