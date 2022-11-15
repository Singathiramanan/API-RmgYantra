package RA_WithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostARequest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void postAJsonBody(){
		JavaUtility ran=new JavaUtility();
		int random = ran.RandomNumber();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Ramanan");
		jobj.put("projectName", "Singathicart"+random);
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
