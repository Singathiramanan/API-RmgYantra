package RA_WithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProject {
	@Test
	public void fetchAllTheprojects(){
		baseURI="http://localhost";
		port=8085;
		given()
		.when()
			.get("/projects")
		.then()
			.log().all()
			.assertThat()
				.statusCode(200);
		
	}

}
