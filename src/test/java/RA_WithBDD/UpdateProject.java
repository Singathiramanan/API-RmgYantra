package RA_WithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@SuppressWarnings("unchecked")
	@Test
	public void completeUpdateProject(){
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
			.put("projects/TY_PROJ_003")
		.then()
			.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.log().all();
			
	}

}
