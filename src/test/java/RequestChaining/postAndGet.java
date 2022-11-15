package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClasses.PojoClassForPostRequest;

public class postAndGet {
	@Test
	public void postandDelete() {
		Random rand=new Random(1000);
		int random=rand.nextInt();
		PojoClassForPostRequest add=new PojoClassForPostRequest("Dinga", "PS3"+random, "created", 122);
		Response response = given().body(add).contentType(ContentType.JSON).when()
		.post("http://localhost:8084/addProject");
		String projID = response.jsonPath().get("projectId");
		
		given().pathParam("projectId", projID)
		.when().get("http://localhost:8084/projects/{projectId}")
		.then().log().all();
		
		
		
		
	}
}
