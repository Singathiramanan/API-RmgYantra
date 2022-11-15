package RA_WithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProjectWithProjectID {
	@Test
	public void getSingleProject(){
		baseURI="http://localhost";
		port=8085;
		given()
			.get("/projects/TY_PROJ_003")
			.then()
				.assertThat()
					.contentType(ContentType.JSON)
					.statusCode(200)
					.log().all();
			
	}
}
