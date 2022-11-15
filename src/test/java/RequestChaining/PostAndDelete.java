package RequestChaining;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClasses.PojoClassForPostRequest;

public class PostAndDelete {

	@Test
	public void postandDelete() {
		Random rand=new Random();
		int random=rand.nextInt();
		PojoClassForPostRequest add=new PojoClassForPostRequest("Dinga", "PS3"+random, "created", 122);
		Response response = given().body(add).contentType(ContentType.JSON).when()
		.post("http://localhost:8084/addProject");
		String projID = response.jsonPath().get("projectId");
		
		given().pathParam("projectId", projID)
		.when().delete("http://localhost:8084/projects/{projectId}")
		.then().log().all();
		
		
		
		
	}
}
