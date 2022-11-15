package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClasses.PojoClassForPostRequest;

public class postgetputDeleteTest {

	@Test
	public void postgetputDelete() {
		Random rand=new Random();
		int random=rand.nextInt();
		PojoClassForPostRequest add=new PojoClassForPostRequest("Dinga", "PS3"+random, "Created", 122);
		Response response = given().body(add).contentType(ContentType.JSON)
		.when().post("http://localhost:8084/addProject");
		String projID = response.jsonPath().get("projectId");
		
		System.out.println(projID);
		
		PojoClassForPostRequest upd = new PojoClassForPostRequest("Dingi","PS3"+random , "Created", 123);
		given().pathParam("projectId", projID).body(upd).contentType(ContentType.JSON)
		.when().put("http://localhost:8084/projects/{projectId}")
		.then().log().all();
		
		given().pathParam("projectId", projID)
		.when().get("http://localhost:8084/projects/{projectId}")
		.then().log().all();
		
		given()
		.when().pathParam("projectId", projID).delete("http://localhost:8084/projects/{projectId}")
		.then().log().all();
		
		
		
		
		
	}
}
