package APITestcases;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostARequestWithOutBaseUrl {
	@SuppressWarnings("unchecked")
	@Test
	public void withoutUrl(){
		Random random=new Random();
		int ran = random.nextInt(1000);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Ramanan");
		jobj.put("projectName", "Singathicart"+ran);
		jobj.put("status", "created");
		jobj.put("teamSize", 6);
		
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
